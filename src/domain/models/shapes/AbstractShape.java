package domain.models.shapes;

import domain.models.ShapeInterface;
import domain.utils.CustomColor;

public abstract class AbstractShape implements ShapeInterface {
    private String name;
    private CustomColor color;

    public AbstractShape(String name, CustomColor color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CustomColor getColor() {
        return color;
    }

    public void setColor(CustomColor color) {
        this.color = color;
    }
}