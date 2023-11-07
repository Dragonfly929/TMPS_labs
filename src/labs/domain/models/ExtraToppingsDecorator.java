package labs.domain.models;

public class ExtraToppingsDecorator extends Pizza {
    private final Pizza pizza;
    private final String extraToppings;

    public ExtraToppingsDecorator(Pizza pizza, String extraToppings) {
        super(pizza.getDough(), pizza.getSauce(), pizza.getToppings() + ", " + extraToppings);
        this.pizza = pizza;
        this.extraToppings = extraToppings;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Extra Toppings: " + extraToppings;
    }
}