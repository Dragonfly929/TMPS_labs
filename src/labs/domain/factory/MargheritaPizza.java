package labs.domain.factory;

import labs.domain.models.Pizza;

public class MargheritaPizza implements PizzaType {
    @Override
    public Pizza createPizza() {
        // Create a Margherita pizza here
        return new Pizza("Thin Dough", "Tomato Sauce", "Mozzarella cheese, Basil leaves");
    }
}
