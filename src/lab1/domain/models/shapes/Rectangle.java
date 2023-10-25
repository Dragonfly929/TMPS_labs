package lab1.domain.models.shapes;

import lab1.domain.utils.CustomColor;

public class Rectangle extends AbstractShape {
    private double width;
    private double height;

    public Rectangle(String name, CustomColor color, double width, double height) {
        super(name, color);
        this.width = width;
        this.height = height;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (width + height);
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}