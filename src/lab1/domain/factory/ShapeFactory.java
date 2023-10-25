package lab1.domain.factory;

import lab1.domain.enums.ShapeName;
import lab1.domain.models.shapes.*;
import lab1.domain.utils.CustomColor;

import java.util.Map;

public class ShapeFactory {
    public static AbstractShape createShape(String name, CustomColor color, Map<String, Object> shapeParams) {
        ShapeName shapeName = (ShapeName) shapeParams.get("shapeName");
        switch (shapeName) {
            case CIRCLE:
                Double radius = (Double) shapeParams.get("radius");
                if (radius == null) {
                    throw new IllegalArgumentException("Missing or null radius parameter for creating a circle.");
                }
                return new Circle(name, color, radius);
            case SQUARE:
                Double sideLength = (Double) shapeParams.get("sideLength");
                if (sideLength == null) {
                    throw new IllegalArgumentException("Missing or null sideLength parameter for creating a square.");
                }
                return new Square(name, color, sideLength);
            // Add similar checks for other shapes
            default:
                throw new IllegalArgumentException("Unsupported shape: " + shapeName);
        }
    }
}
