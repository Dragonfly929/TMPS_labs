package lab1.domain.models.shapes;
import lab1.domain.utils.CustomColor;

public class Circle extends AbstractShape {
    private double radius;

    public Circle(String name, CustomColor color, double radius) {
        super(name, color);
        this.radius = radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
