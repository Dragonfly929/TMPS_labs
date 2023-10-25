package lab2.domain.factory;

import lab2.domain.models.Pizza;
import lab2.domain.models.PizzaBuilder;

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