package lab2.domain.factory;


import lab2.domain.models.Pizza;
import lab2.domain.models.PizzaBuilder;

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