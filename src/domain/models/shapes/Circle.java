package domain.models.shapes;

import domain.models.utils.ShapeColor;

public class Circle extends AbstractShape implements Validatable {
    private double radius; // Changed to non-final

    public Circle(ShapeName name, ShapeColor color, double radius) {
        super(name, color);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public boolean isValid() {
        return radius > 0;
    }

    @Override
    public AbstractShape clone() {
        // Create a new Circle instance and copy relevant attributes
        return new Circle(getName(), color, radius);
    }

    public static class CircleBuilder {
        private ShapeName name;
        private ShapeColor color;
        private double radius;

        public CircleBuilder name(ShapeName name) {
            this.name = name;
            return this;
        }

        public CircleBuilder color(ShapeColor color) {
            this.color = color;
            return this;
        }

        public CircleBuilder radius(double radius) {
            this.radius = radius;
            return this;
        }

        public Circle build() {
            if (name == null || color == null) {
                throw new IllegalArgumentException("Name and color are required.");
            }

            return new Circle(name, color, radius);
        }
    }
}
