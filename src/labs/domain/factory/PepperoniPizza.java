package labs.domain.factory;

import labs.domain.models.Pizza;

public class PepperoniPizza implements PizzaType {
    @Override
    public Pizza createPizza() {
        // Create a Pepperoni pizza here
        return new Pizza("Thick Dough", "Tomato Sauce", "Pepperoni, Cheese");
    }
}
