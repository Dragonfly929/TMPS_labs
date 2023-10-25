package lab1.domain.factory;

import lab1.domain.models.shapes.AbstractShape;
import lab1.domain.utils.CustomColor;

import java.util.Map;

public interface ShapeCreator {
    AbstractShape createShape(String name, CustomColor color, Map<String, Object> shapeParams);
}