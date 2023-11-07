package labs.domain.models;

public abstract class PizzaDecorator extends Pizza {
    protected Pizza decoratedPizza;

    public PizzaDecorator(Pizza decoratedPizza) {
        super(decoratedPizza.getDough(), decoratedPizza.getSauce(), decoratedPizza.getToppings());
        this.decoratedPizza = decoratedPizza;
    }

    @Override
    public String getDescription() {
        return decoratedPizza.getDescription();
    }
}