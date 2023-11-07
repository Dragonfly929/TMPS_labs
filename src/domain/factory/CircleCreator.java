package domain.factory;

import domain.models.utils.ShapeColor;
import domain.models.shapes.ShapeName;
import domain.models.shapes.AbstractShape;
import domain.models.shapes.Circle;
import domain.models.shapes.ShapePrototype;

import java.util.Map;

public class CircleCreator implements ShapeFactory {
    private static CircleCreator instance; // Static instance variable
    private Circle prototype; // The prototype shape

    // Private constructor to prevent external instantiation
    private CircleCreator() {
        // Create a default circle prototype
        prototype = new Circle(ShapeName.CIRCLE, ShapeColor.BLUE, 1.0);
    }

    // Static method to provide access to the single instance
    public static CircleCreator getInstance() {
        if (instance == null) {
            instance = new CircleCreator();
        }
        return instance;
    }

    @Override
    public AbstractShape createShape(ShapeName name, ShapeColor color, Map<String, Object> shapeParams) {
        if (shapeParams.containsKey("radius")) {
            double radius = (double) shapeParams.get("radius");

            // Use the prototype pattern to create a new Circle by cloning the prototype
            Circle newCircle = (Circle) prototype.clone(); // Use the clone method
            newCircle.setName(name); // Set the name
            newCircle.setColor(color); // Set the color
            newCircle.setRadius(radius); // Set the radius

            return newCircle;
        } else {
            throw new IllegalArgumentException("Missing or null parameters for creating a circle.");
        }
    }
}
