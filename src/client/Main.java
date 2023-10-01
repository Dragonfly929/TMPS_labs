package client;

import domain.factory.*;
import domain.models.shapes.AbstractShape;
import domain.enums.ShapeName;
import domain.enums.ShapeColor;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ShapeName randomShapeName = getRandomEnum(ShapeName.class);
        ShapeColor randomShapeColor = getRandomEnum(ShapeColor.class);

        AbstractShape shape;
        String shapeType;

        // Create a map of parameters based on the chosen shape
        Map<String, Object> shapeParams = new HashMap<>();
        shapeParams.put("shapeName", randomShapeName);

        switch (randomShapeName) {
            case CIRCLE:
                shapeParams.put("radius", 5.0);
                shapeType = "Circle";
                break;
            case SQUARE:
                shapeParams.put("sideLength", 3.0);
                shapeType = "Square";
                break;
            case RECTANGLE:
                shapeParams.put("width", 4.0);
                shapeParams.put("height", 6.0);
                shapeType = "Rectangle";
                break;
            case POLYGON:
                shapeParams.put("numSides", 6);
                shapeParams.put("sideLength", 5.0);
                shapeType = "Regular Polygon";
                break;
            case TRIANGLE:
                shapeParams.put("a", 4.0);
                shapeParams.put("b", 5.0);
                shapeParams.put("c", 3.0);
                shapeType = "Triangle";
                break;
            // Add cases for other shape types
            default:
                shape = null;
                shapeType = "Unknown";
        }

        // Create the shape using the factory and provided parameters
        if (shapeParams.containsKey("shapeName")) {
            shape = ShapeFactory.createShape("Shape", randomShapeColor.toCustomColor(), shapeParams);
        } else {
            shape = null;
        }

        if (shape != null) {
            // Change text color based on the selected color
            changeConsoleTextColor(new Color(randomShapeColor.getRed(), randomShapeColor.getGreen(), randomShapeColor.getBlue()));

            System.out.println("Created " + shapeType + " with color: " + randomShapeColor);
            System.out.println(shapeType + " Area: " + shape.calculateArea());
            System.out.println(shapeType + " Perimeter: " + shape.calculatePerimeter());

            resetConsoleTextColor();
        } else {
            System.out.println("Failed to create a shape.");
        }
    }

    // Helper method to get a random enum value
    private static <T extends Enum<?>> T getRandomEnum(Class<T> enumClass) {
        T[] values = enumClass.getEnumConstants();
        return values[new Random().nextInt(values.length)];
    }

    // Helper method to change console text color
    private static void changeConsoleTextColor(Color color) {
        System.out.print("\033[38;2;" + color.getRed() + ";" + color.getGreen() + ";" + color.getBlue() + "m");
    }

    // Helper method to reset console text color to default
    private static void resetConsoleTextColor() {
        System.out.print("\033[0m");
    }
}
