package domain.models.shapes;

import domain.models.utils.ShapeColor;

public class TriangleSides extends AbstractShape implements Validatable, TriangleType {
    private double sideA;
    private double sideB;
    private double sideC;

    private TriangleSides(ShapeName name, ShapeColor color, double sideA, double sideB, double sideC) {
        super(name, color);
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    public double getSideA() {
        return sideA;
    }

    public double getSideB() {
        return sideB;
    }

    public double getSideC() {
        return sideC;
    }

    @Override
    public AbstractShape clone() {
        // Create a new Triangle instance and copy relevant attributes
        return new TriangleSides(getName(), color, sideA, sideB, sideC);
    }


    public static class TriangleSidesBuilder {
        private ShapeName name;
        private ShapeColor color;
        private double sideA;
        private double sideB;
        private double sideC;

        public TriangleSidesBuilder() {
        }

        public TriangleSidesBuilder name(ShapeName name) {
            this.name = name;
            return this;
        }

        public TriangleSidesBuilder color(ShapeColor color) {
            this.color = color;
            return this;
        }

        public TriangleSidesBuilder sideA(double sideA) {
            this.sideA = sideA;
            return this;
        }

        public TriangleSidesBuilder sideB(double sideB) {
            this.sideB = sideB;
            return this;
        }

        public TriangleSidesBuilder sideC(double sideC) {
            this.sideC = sideC;
            return this;
        }

        public TriangleSides build() {
            if (name == null || color == null || sideA <= 0 || sideB <= 0 || sideC <= 0 || !isValidTriangle())
                throw new IllegalArgumentException("Invalid parameters for creating a triangle with given sides.");

            return new TriangleSides(name, color, sideA, sideB, sideC);
        }

        private boolean isValidTriangle() {
            return (sideA + sideB > sideC) && (sideA + sideC > sideB) && (sideB + sideC > sideA);
        }
    }

    @Override
    public double calculatePerimeter() {
        return sideA + sideB + sideC;
    }

    @Override
    public double calculateArea() {
        double s = calculatePerimeter() / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    @Override
    public boolean isValid() {
        return (sideA > 0) && (sideB > 0) && (sideC > 0) &&
                (sideA + sideB > sideC) && (sideA + sideC > sideB) && (sideB + sideC > sideA);
    }

    @Override
    public String typeTriangleSide() {
        if (sideA == sideB && sideB == sideC)
            return "Equilateral";
        else if (sideA == sideB || sideB == sideC || sideA == sideC)
            return "Isosceles";
        else
            return "Scalene";
    }

    @Override
    public String typeTriangleAngle() {
        double x = sideA * sideA;
        double y = sideB * sideB;
        double z = sideC * sideC;
        if (sideA > sideB && sideA > sideC) {
            if (x == y + z)
                return "Right-angled";
            else if (x < y + z)
                return "Acute-angled";
            else
                return "Obtuse-angled";
        } else if (sideB > sideA && sideB > sideC) {
            if (y == x + z)
                return "Right-angled";
            else if (y < x + z)
                return "Acute-angled";
            else
                return "Obtuse-angled";
        } else {
            if (z == x + y)
                return "Right-angled";
            else if (z < x + y)
                return "Acute-angled";
            else
                return "Obtuse-angled";
        }
    }
}
