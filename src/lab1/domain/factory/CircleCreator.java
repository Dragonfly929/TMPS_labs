package lab1.domain.factory;

import lab1.domain.models.shapes.AbstractShape;
import lab1.domain.models.shapes.Circle;
import lab1.domain.utils.CustomColor;

import java.util.Map;

public class CircleCreator implements ShapeCreator {
    @Override
    public AbstractShape createShape(String name, CustomColor color, Map<String, Object> shapeParams) {
        double radius = (double) shapeParams.get("radius");
        return new Circle(name, color, radius);
    }
}