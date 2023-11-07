package labs.domain.factory;

import labs.domain.models.Pizza;
import labs.domain.builder.PizzaBuilder;

public class MargheritaPizzaMaker implements PizzaMaker {
    @Override
    public Pizza createPizza() {
        return new PizzaBuilder()
                .setDough(Pizza.THIN_DOUGH)
                .setSauce(Pizza.TOMATO_SAUCE)
                .setToppings("Mozzarella cheese, Basil leaves")
                .build();
    }
}