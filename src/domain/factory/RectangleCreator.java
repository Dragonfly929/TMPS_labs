package domain.factory;

import domain.models.shapes.AbstractShape;
import domain.models.shapes.Rectangle;
import domain.utils.CustomColor;

import java.util.Map;

public class RectangleCreator implements ShapeCreator {
    @Override
    public AbstractShape createShape(String name, CustomColor color, Map<String, Object> shapeParams) {
        double width = (double) shapeParams.get("width");
        double height = (double) shapeParams.get("height");
        return new Rectangle(name, color, width, height);
    }
}