package domain.models.shapes;

import domain.models.utils.ShapeColor;
import domain.models.Shape;
import domain.models.utils.CustomColor;

public abstract class AbstractShape implements Shape {
    private ShapeName name;
    ShapeColor color;

    // Constructor to initialize common attributes
    public AbstractShape(ShapeName name, ShapeColor color) {
        this.name = name;
        this.color = color;
    }

    // Prototype constructor to create a new object with values copied from an existing object
    public AbstractShape(AbstractShape source) {
        this.name = source.name;
        this.color = source.color;
    }

    public ShapeName getName() {
        return name;
    }

    public void setName(ShapeName name) {
        this.name = name;
    }

    public CustomColor getColor() {
        return color.toCustomColor();
    }

    public void setColor(ShapeColor color) {
        this.color = color;
    }

    // Abstract method to be implemented by concrete shapes for cloning
    public abstract AbstractShape clone();
}
