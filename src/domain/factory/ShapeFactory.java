package domain.factory;

import domain.models.utils.ShapeColor;
import domain.models.shapes.ShapeName;
import domain.models.shapes.AbstractShape;

import java.util.Map;

public interface ShapeFactory {
    AbstractShape createShape(ShapeName name, ShapeColor color, Map<String, Object> shapeParams);
}
