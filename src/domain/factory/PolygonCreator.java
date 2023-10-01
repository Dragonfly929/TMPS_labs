package domain.factory;

import domain.models.shapes.AbstractShape;
import domain.models.shapes.RegularPolygon;
import domain.utils.CustomColor;

import java.util.Map;

public class PolygonCreator implements ShapeCreator {
    @Override
    public AbstractShape createShape(String name, CustomColor color, Map<String, Object> shapeParams) {
        Integer numSides = (Integer) shapeParams.get("numSides");
        Double sideLength = (Double) shapeParams.get("sideLength");

        if (numSides == null || sideLength == null) {
            throw new IllegalArgumentException("Missing or null parameters for creating a polygon.");
        }

        return new RegularPolygon(name, color, numSides, sideLength);
    }
}
