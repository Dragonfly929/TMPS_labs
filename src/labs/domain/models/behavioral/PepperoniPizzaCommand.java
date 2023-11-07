package labs.domain.models.behavioral;

import labs.domain.models.Pizza;

public class PepperoniPizzaCommand implements PizzaCommand {
    private Pizza pizza;

    public PepperoniPizzaCommand(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public void execute() {
        // Prepare the Pepperoni pizza (specific logic)
        System.out.println("Preparing Pepperoni Pizza: " + pizza.getDescription());
    }

    @Override
    public Pizza getPizza() {
        return pizza;
    }
}