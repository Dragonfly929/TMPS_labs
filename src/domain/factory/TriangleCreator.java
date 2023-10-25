package domain.factory;

import domain.models.shapes.AbstractShape;
import domain.models.shapes.TriangleSides;
import domain.utils.CustomColor;

import java.util.Map;

public class TriangleCreator implements ShapeCreator {
    @Override
    public AbstractShape createShape(String name, CustomColor color, Map<String, Object> shapeParams) {
        double a = (double) shapeParams.get("a");
        double b = (double) shapeParams.get("b");
        double c = (double) shapeParams.get("c");
        return new TriangleSides(name, color, a, b, c);
    }
}