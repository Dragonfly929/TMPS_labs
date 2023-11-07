package labs.domain.models;

public class PizzaV1 {
    private String dough;
    private String sauce;
    private String toppings;

    public PizzaV1(String dough, String sauce, String toppings) {
        this.dough = dough;
        this.sauce = sauce;
        this.toppings = toppings;
    }

    public String getDough() {
        return dough;
    }

    public String getSauce() {
        return sauce;
    }

    public String getToppings() {
        return toppings;
    }
}
