package labs.domain.models;

// Prototype Pattern
public class CloneablePizza implements Cloneable {
    private String type;

    public CloneablePizza(String type) {
        this.type = type;
    }

    @Override
    public CloneablePizza clone() throws CloneNotSupportedException {
        return (CloneablePizza) super.clone();
    }

    public String getType() {
        return type;
    }
}