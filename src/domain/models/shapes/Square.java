package domain.models.shapes;


import domain.models.utils.ShapeColor;

public class Square extends AbstractShape implements Validatable {
    private double sideLength;

    public Square(ShapeName name, ShapeColor color, double sideLength) {
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

    @Override
    public boolean isValid() {
        return sideLength > 0;
    }

    @Override
    public AbstractShape clone() {
        // Create a new Square instance and copy relevant attributes
        return new Square(getName(), color, sideLength);
    }

}
