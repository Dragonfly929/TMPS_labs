package labs.domain.factory;

import labs.domain.models.Pizza;

public class PepperoniPizzaBridge implements PizzaBridge {
    private PizzaMaker pizzaMaker;

    public PepperoniPizzaBridge(PizzaMaker pizzaMaker) {
        this.pizzaMaker = pizzaMaker;
    }

    @Override
    public Pizza makePizza() {
        return pizzaMaker.createPizza();
    }
}