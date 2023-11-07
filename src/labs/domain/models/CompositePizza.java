package labs.domain.models;

import java.util.ArrayList;
import java.util.List;

public class CompositePizza extends Pizza {
    private List<Pizza> pizzas = new ArrayList<>();

    public CompositePizza(String dough, String sauce, String toppings) {
        super(dough, sauce, toppings);
    }

    public void addPizza(Pizza pizza) {
        pizzas.add(pizza);
    }

    public void removePizza(Pizza pizza) {
        pizzas.remove(pizza);
    }

    @Override
    public String getDescription() {
        StringBuilder description = new StringBuilder(super.getDescription());
        description.append(" with:\n");
        for (Pizza pizza : pizzas) {
            description.append("  - ").append(pizza.getDescription()).append("\n");
        }
        return description.toString();
    }
}
