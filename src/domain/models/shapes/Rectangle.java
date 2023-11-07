package domain.models.shapes;

import domain.models.utils.ShapeColor;

public class Rectangle extends AbstractShape implements Validatable {
    private double width;
    private double height;

    private Rectangle(ShapeName name, ShapeColor color, double width, double height) {
        super(name, color);
        this.width = width;
        this.height = height;
    }

    // Getter methods for width and height

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    // Calculate the perimeter and area methods

    @Override
    public double calculatePerimeter() {
        return 2 * (width + height);
    }

    @Override
    public double calculateArea() {
        return width * height;
    }


    @Override
    public boolean isValid() {
        return width > 0 && height > 0;
    }

    @Override
    public AbstractShape clone() {
        // Create a new Rectangle instance and copy relevant attributes
        return new Rectangle(getName(), color, width, height);
    }

    public static class RectangleBuilder {
        private ShapeName name;
        private ShapeColor color;
        private double width;
        private double height;

        public RectangleBuilder() {
        }

        public RectangleBuilder name(ShapeName name) {
            this.name = name;
            return this;
        }

        public RectangleBuilder color(ShapeColor color) {
            this.color = color;
            return this;
        }

        public RectangleBuilder width(double width) {
            this.width = width;
            return this;
        }

        public RectangleBuilder height(double height) {
            this.height = height;
            return this;
        }

        public Rectangle build() {
            if (name == null || color == null) {
                throw new IllegalArgumentException("Name and color are required.");
            }

            return new Rectangle(name, color, width, height);
        }
    }
}
