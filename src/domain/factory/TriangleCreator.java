package domain.factory;

import domain.models.utils.ShapeColor;
import domain.models.shapes.ShapeName;
import domain.models.shapes.AbstractShape;
import domain.models.shapes.TriangleSides;
import domain.models.shapes.Validatable;

import java.util.Map;

public class TriangleCreator implements ShapeFactory {
    private static TriangleCreator instance; // Static instance variable

    // Private constructor to prevent external instantiation
    private TriangleCreator() {
    }

    // Static method to provide access to the single instance
    public static TriangleCreator getInstance() {
        if (instance == null) {
            instance = new TriangleCreator();
        }
        return instance;
    }

    @Override
    public AbstractShape createShape(ShapeName name, ShapeColor color, Map<String, Object> shapeParams) {
        TriangleSides.TriangleSidesBuilder builder = new TriangleSides.TriangleSidesBuilder();

        if (shapeParams.containsKey("sideA") && shapeParams.containsKey("sideB") && shapeParams.containsKey("sideC")) {
            double sideA = (double) shapeParams.get("sideA");
            double sideB = (double) shapeParams.get("sideB");
            double sideC = (double) shapeParams.get("sideC");

            AbstractShape triangle = builder
                    .name(name)
                    .color(color)
                    .sideA(sideA)
                    .sideB(sideB)
                    .sideC(sideC)
                    .build();

            return triangle;
        } else {
            throw new IllegalArgumentException("Missing or null parameters for creating a triangle.");
        }
    }
}
