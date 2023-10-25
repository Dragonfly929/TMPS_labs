package domain.models.shapes;

import domain.utils.CustomColor;

import domain.models.ShapeInterface;
import domain.utils.CustomColor;

public class Square extends AbstractShape {
    private double sideLength;

    public Square(String name, CustomColor color, double sideLength) {
        super(name, color);
        this.sideLength = sideLength;
    }

    @Override
    public double calculatePerimeter() {
        return 4 * sideLength;
    }

    @Override
    public double calculateArea() {
        return sideLength * sideLength;
    }

    public double getSideLength() {
        return sideLength;
    }

    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
    }
}