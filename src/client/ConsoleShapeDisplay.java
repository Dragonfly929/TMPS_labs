package client;

import domain.models.Shape;
import domain.models.utils.CustomColor;

public class ConsoleShapeDisplay implements ShapeDisplay {
    private Shape shape;

    @Override
    public void displayShape(Shape shape) {
        // Change text color based on the selected color
        changeConsoleTextColor(shape.getColor());

        String shapeType = shape.getClass().getSimpleName();
        System.out.println("Created " + shapeType);
        System.out.println(shapeType + " Area: " + shape.calculateArea());
        System.out.println(shapeType + " Perimeter: " + shape.calculatePerimeter());

        resetConsoleTextColor();
    }

    // Helper methods to change console text color
    private static void changeConsoleTextColor(CustomColor color) {
        System.out.print("\033[38;2;" + color.getRed() + ";" + color.getGreen() + ";" + color.getBlue() + "m");
    }

    private static void resetConsoleTextColor() {
        System.out.print("\033[0m");
    }
}
