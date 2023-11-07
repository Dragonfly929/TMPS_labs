package domain.models.shapes;

import domain.models.InteriorAngleCalculator;
import domain.models.utils.ShapeColor;
import domain.models.shapes.ShapeName;

public class RegularPolygon extends AbstractShape implements Validatable, InteriorAngleCalculator {
    private int numSides;
    private double sideLength;

    private RegularPolygon(ShapeName name, ShapeColor color, int numSides, double sideLength) {
        super(name, color);
        this.numSides = numSides;
        this.sideLength = sideLength;
    }

    @Override
    public AbstractShape clone() {
        // Create a new RegularPolygon instance and copy relevant attributes
        return new RegularPolygon(getName(), color, numSides, sideLength);
    }

    public static class RegularPolygonBuilder {
        private ShapeName name;
        private ShapeColor color;
        private int numSides;
        private double sideLength;

        public RegularPolygonBuilder() {
        }

        public RegularPolygonBuilder name(ShapeName name) {
            this.name = name;
            return this;
        }

        public RegularPolygonBuilder color(ShapeColor color) {
            this.color = color;
            return this;
        }

        public RegularPolygonBuilder numSides(int numSides) {
            this.numSides = numSides;
            return this;
        }

        public RegularPolygonBuilder sideLength(double sideLength) {
            this.sideLength = sideLength;
            return this;
        }

        public RegularPolygon build() {
            if (name == null || color == null || numSides < 3 || sideLength <= 0) {
                throw new IllegalArgumentException("Invalid parameters for creating a regular polygon.");
            }

            return new RegularPolygon(name, color, numSides, sideLength);
        }
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

    @Override
    public boolean isValid() {
        return numSides >= 3 && sideLength > 0;
    }

    @Override
    public String getInteriorAngle() {
        double sum = 180 * (numSides - 2);
        return "Regular Polygon's Interior angle sum: " + sum + " degrees" +
                "\nInterior angle: " + sum / numSides;
    }
}
