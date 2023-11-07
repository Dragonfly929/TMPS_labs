package labs.domain.models.behavioral;

import labs.domain.models.Pizza;

public class MargheritaPizzaCommand implements PizzaCommand {
    private Pizza pizza;

    public MargheritaPizzaCommand(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public void execute() {
        // Prepare the Margherita pizza (specific logic)
        System.out.println("Preparing Margherita Pizza: " + pizza.getDescription());
    }

    @Override
    public Pizza getPizza() {
        return pizza;
    }
}
