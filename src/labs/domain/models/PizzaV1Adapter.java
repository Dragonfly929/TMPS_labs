package labs.domain.models;

public class PizzaV1Adapter extends PizzaV2 {
    private PizzaV1 pizzaV1;

    public PizzaV1Adapter(PizzaV1 pizzaV1) {
        super(pizzaV1.getDough(), pizzaV1.getSauce(), pizzaV1.getToppings());
        this.pizzaV1 = pizzaV1;
    }

    @Override
    public String getDescription() {
        return "Pizza with " + pizzaV1.getDough() + " dough, " + pizzaV1.getSauce() + " sauce, and " + pizzaV1.getToppings() + " toppings.";
    }
}
