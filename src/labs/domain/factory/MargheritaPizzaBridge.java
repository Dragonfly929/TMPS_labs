package labs.domain.factory;

import labs.domain.models.Pizza;

public class MargheritaPizzaBridge implements PizzaBridge {
    private PizzaMaker pizzaMaker;

    public MargheritaPizzaBridge(PizzaMaker pizzaMaker) {
        this.pizzaMaker = pizzaMaker;
    }

    @Override
    public Pizza makePizza() {
        return pizzaMaker.createPizza();
    }
}