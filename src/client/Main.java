package client;

import domain.models.shapes.RegularPolygon;
import domain.models.shapes.TriangleType;
import domain.models.utils.ShapeColor;
import domain.models.shapes.ShapeName;
import domain.factory.*;
import domain.models.shapes.AbstractShape;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        // Create instances of shape factories
        ShapeFactory circleFactory = CircleCreator.getInstance();
        ShapeFactory squareFactory = SquareCreator.getInstance();
        ShapeFactory rectangleFactory = RectangleCreator.getInstance();
        ShapeFactory polygonFactory = PolygonCreator.getInstance();
        ShapeFactory triangleFactory = TriangleCreator.getInstance();

        ShapeDisplay shapeDisplay = new ConsoleShapeDisplay();  // Create the ShapeDisplay instance

        while (!exit) {
            System.out.print("Enter the shape (CIRCLE, SQUARE, RECTANGLE, POLYGON, TRIANGLE), or type 'exit' to quit: ");
            String shapeInput = scanner.nextLine();

            if (shapeInput.equalsIgnoreCase("exit")) {
                exit = true;
                continue;
            }

            try {
                ShapeName selectedShape = ShapeName.valueOf(shapeInput);

                System.out.print("Enter the shape color (RED, GREEN, BLUE, YELLOW, CYAN, MAGENTA, ORANGE): ");
                String colorInput = scanner.nextLine().toUpperCase();
                ShapeColor selectedColor = ShapeColor.valueOf(colorInput);

                AbstractShape shape = null;  // Initialize shape with a default value

                Map<String, Object> shapeParams = new HashMap<>();
                shapeParams.put("shapeName", selectedShape);

                switch (selectedShape) {
                    case CIRCLE:
                        System.out.print("Enter the radius for the circle: ");
                        double radius = Double.parseDouble(scanner.nextLine());
                        shapeParams.put("radius", radius);
                        shape = createShape(circleFactory, selectedShape, selectedColor, shapeParams);
                        break;
                    case SQUARE:
                        System.out.print("Enter the side length for the square: ");
                        double sideLength = Double.parseDouble(scanner.nextLine());
                        shapeParams.put("sideLength", sideLength);
                        shape = createShape(squareFactory, selectedShape, selectedColor, shapeParams);
                        break;
                    case RECTANGLE:
                        System.out.print("Enter the width for the rectangle: ");
                        double width = Double.parseDouble(scanner.nextLine());
                        System.out.print("Enter the height for the rectangle: ");
                        double height = Double.parseDouble(scanner.nextLine());
                        shapeParams.put("width", width);
                        shapeParams.put("height", height);
                        shape = createShape(rectangleFactory, selectedShape, selectedColor, shapeParams);
                        break;
                    case POLYGON:
                        System.out.print("Enter the number of sides for the polygon: ");
                        int numSides = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter the side length for the polygon: ");
                        double sidesLength = Double.parseDouble(scanner.nextLine());
                        shapeParams.put("numSides", numSides);
                        shapeParams.put("sideLength", sidesLength);
                        shape = createShape(polygonFactory, selectedShape, selectedColor, shapeParams);

                        if (shape instanceof RegularPolygon) {
                            RegularPolygon regularPolygon = (RegularPolygon) shape;
                            String interiorAngle = regularPolygon.getInteriorAngle();
                            System.out.println(interiorAngle);
                        }
                        break;
                    case TRIANGLE:
                        System.out.print("Enter the length of side A for the triangle: ");
                        double sideA = Double.parseDouble(scanner.nextLine());
                        System.out.print("Enter the length of side B for the triangle: ");
                        double sideB = Double.parseDouble(scanner.nextLine());
                        System.out.print("Enter the length of side C for the triangle: ");
                        double sideC = Double.parseDouble(scanner.nextLine());
                        shapeParams.put("sideA", sideA);
                        shapeParams.put("sideB", sideB);
                        shapeParams.put("sideC", sideC);
                        shape = createShape(triangleFactory, selectedShape, selectedColor, shapeParams);

                        if (shape instanceof TriangleType) {
                            TriangleType triangle = (TriangleType) shape;
                            String typeBySides = triangle.typeTriangleSide();
                            String typeByAngle = triangle.typeTriangleAngle();
                            System.out.println("Type by Sides: " + typeBySides);
                            System.out.println("Type by Angle: " + typeByAngle);
                        }
                        break;

                }

                if (shape != null) {
                    System.out.println("Selected Shape: " + selectedShape);
                    System.out.println("Selected Color: " + selectedColor);
                    shapeDisplay.displayShape(shape);  // Display the created shape
                } else {
                    System.out.println("Failed to create a shape.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input. Please enter a valid input or 'exit' to quit.");
            }
        }
    }

    private static AbstractShape createShape(ShapeFactory shapeFactory, ShapeName name, ShapeColor color, Map<String, Object> shapeParams) {
        AbstractShape shape;
        shape = shapeFactory.createShape(name, color, shapeParams);
        return shape;
    }
}
