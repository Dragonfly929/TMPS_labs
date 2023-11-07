package domain.factory;

import domain.models.utils.ShapeColor;
import domain.models.shapes.ShapeName;
import domain.models.shapes.AbstractShape;
import domain.models.shapes.RegularPolygon;

import java.util.Map;

public class PolygonCreator implements ShapeFactory {
    private static PolygonCreator instance; // Static instance variable

    // Private constructor to prevent external instantiation
    private PolygonCreator() {
    }

    // Static method to provide access to the single instance
    public static PolygonCreator getInstance() {
        if (instance == null) {
            instance = new PolygonCreator();
        }
        return instance;
    }

    @Override
    public AbstractShape createShape(ShapeName name, ShapeColor color, Map<String, Object> shapeParams) {
        if (shapeParams.containsKey("numSides") && shapeParams.containsKey("sideLength")) {
            int numSides = (int) shapeParams.get("numSides");
            double sideLength = (double) shapeParams.get("sideLength");

            // Use the builder pattern to create a RegularPolygon
            RegularPolygon polygon = new RegularPolygon.RegularPolygonBuilder()
                    .name(name)
                    .color(color)
                    .numSides(numSides)
                    .sideLength(sideLength)
                    .build();

            if (polygon.isValid()) {
                return polygon;
            } else {
                throw new IllegalArgumentException("Invalid parameters for creating a polygon.");
            }
        } else {
            throw new IllegalArgumentException("Missing or null parameters for creating a polygon.");
        }
    }
}
