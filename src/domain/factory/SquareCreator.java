package domain.factory;

import domain.models.utils.ShapeColor;
import domain.models.shapes.ShapeName;
import domain.models.shapes.AbstractShape;
import domain.models.shapes.Square;
import domain.models.shapes.Validatable;

import java.util.Map;

public class SquareCreator implements ShapeFactory {
    private static SquareCreator instance; // Static instance variable

    // Private constructor to prevent external instantiation
    private SquareCreator() {
    }

    // Static method to provide access to the single instance
    public static SquareCreator getInstance() {
        if (instance == null) {
            instance = new SquareCreator();
        }
        return instance;
    }

    @Override
    public AbstractShape createShape(ShapeName name, ShapeColor color, Map<String, Object> shapeParams) {
        if (shapeParams.containsKey("sideLength")) {
            double sideLength = (double) shapeParams.get("sideLength");
            Validatable square = new Square(name, color, sideLength);
            if (square.isValid()) {
                return (AbstractShape) square;
            } else {
                throw new IllegalArgumentException("Invalid parameters for creating a square.");
            }
        } else {
            throw new IllegalArgumentException("Missing or null parameters for creating a square.");
        }
    }
}
