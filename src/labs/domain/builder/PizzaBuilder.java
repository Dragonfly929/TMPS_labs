package labs.domain.builder;

import labs.domain.models.Pizza;

public class PizzaBuilder {
    private String dough = Pizza.THIN_DOUGH;
    private String sauce = Pizza.TOMATO_SAUCE;
    private String toppings = "";

    public PizzaBuilder setDough(String dough) {
        this.dough = dough;
        return this;
    }

    public PizzaBuilder setSauce(String sauce) {
        this.sauce = sauce;
        return this;
    }

    public PizzaBuilder setToppings(String toppings) {
        this.toppings = toppings;
        return this;
    }

    public Pizza build() {
        return new Pizza(dough, sauce, toppings);
    }
}
