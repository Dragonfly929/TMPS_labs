package domain.factory;

import domain.models.shapes.AbstractShape;
import domain.models.shapes.Circle;
import domain.utils.CustomColor;

import java.util.Map;

public class CircleCreator implements ShapeCreator {
    @Override
    public AbstractShape createShape(String name, CustomColor color, Map<String, Object> shapeParams) {
        double radius = (double) shapeParams.get("radius");
        return new Circle(name, color, radius);
    }
}