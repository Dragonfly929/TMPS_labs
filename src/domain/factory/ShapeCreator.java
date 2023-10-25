package domain.factory;

import domain.models.shapes.AbstractShape;
import domain.utils.CustomColor;

import java.util.Map;

public interface ShapeCreator {
    AbstractShape createShape(String name, CustomColor color, Map<String, Object> shapeParams);
}