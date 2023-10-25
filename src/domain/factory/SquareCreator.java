package domain.factory;

import domain.models.shapes.AbstractShape;
import domain.models.shapes.Square;
import domain.utils.CustomColor;

import java.util.Map;

public class SquareCreator implements ShapeCreator {
    @Override
    public AbstractShape createShape(String name, CustomColor color, Map<String, Object> shapeParams) {
        Double sideLength = (Double) shapeParams.get("sideLength");

        if (sideLength == null) {
            throw new IllegalArgumentException("Missing or null sideLength parameter for creating a square.");
        }

        return new Square(name, color, sideLength);
    }
}

