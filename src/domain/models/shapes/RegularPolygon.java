package domain.models.shapes;

import domain.utils.CustomColor;

import domain.models.ShapeInterface;
import domain.utils.CustomColor;

public class RegularPolygon extends AbstractShape {
    private int numSides;
    private double sideLength;

    public RegularPolygon(String name, CustomColor color, int numSides, double sideLength) {
        super(name, color);
        this.numSides = numSides;
        this.sideLength = sideLength;
    }

    @Override
    public double calculatePerimeter() {
        return numSides * sideLength;
    }

    @Override
    public double calculateArea() {
        return (numSides * sideLength * sideLength) / (4 * Math.tan(Math.PI / numSides));
    }

    public int getNumSides() {
        return numSides;
    }

    public void setNumSides(int numSides) {
        this.numSides = numSides;
    }

    public double getSideLength() {
        return sideLength;
    }

    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
    }
}