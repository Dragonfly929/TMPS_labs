package labs.domain.factory;


import labs.domain.models.Pizza;
import labs.domain.builder.PizzaBuilder;

public class PepperoniPizzaMaker implements PizzaMaker {
    @Override
    public Pizza createPizza() {
        return new PizzaBuilder()
                .setDough(Pizza.THICK_DOUGH)
                .setSauce(Pizza.TOMATO_SAUCE)
                .setToppings("Pepperoni, Cheese")
                .build();
    }
}