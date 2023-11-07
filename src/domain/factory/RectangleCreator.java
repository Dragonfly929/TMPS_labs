package domain.factory;

import domain.models.utils.ShapeColor;
import domain.models.shapes.ShapeName;
import domain.models.shapes.AbstractShape;
import domain.models.shapes.Rectangle;
import domain.models.shapes.Validatable;

import java.util.Map;

public class RectangleCreator implements ShapeFactory {
    // Singleton instance
    private static RectangleCreator instance;

    // Private constructor to prevent external instantiation
    private RectangleCreator() {
    }

    // Singleton instance getter
    public static RectangleCreator getInstance() {
        if (instance == null) {
            instance = new RectangleCreator();
        }
        return instance;
    }

    @Override
    public AbstractShape createShape(ShapeName name, ShapeColor color, Map<String, Object> shapeParams) {
        if (shapeParams.containsKey("width") && shapeParams.containsKey("height")) {
            double width = (double) shapeParams.get("width");
            double height = (double) shapeParams.get("height");
            Validatable rectangle = new Rectangle.RectangleBuilder()
                    .name(name)
                    .color(color)
                    .width(width)
                    .height(height)
                    .build();

            if (rectangle.isValid()) {
                return (AbstractShape) rectangle;
            } else {
                throw new IllegalArgumentException("Invalid parameters for creating a rectangle.");
            }
        } else {
            throw new IllegalArgumentException("Missing or null parameters for creating a rectangle.");
        }
    }
}
