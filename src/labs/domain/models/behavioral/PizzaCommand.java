package labs.domain.models.behavioral;

import labs.domain.models.Pizza;



public interface PizzaCommand {
    void execute();
    Pizza getPizza();
}
