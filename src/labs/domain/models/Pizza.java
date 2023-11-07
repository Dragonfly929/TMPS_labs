package labs.domain.models;

// Builder Pattern
public class Pizza {
    public static final String THIN_DOUGH = "Thin";
    public static final String THICK_DOUGH = "Thick";
    public static final String TOMATO_SAUCE = "Tomato";

    private String dough;
    private String sauce;
    private String toppings;

    public Pizza(String dough, String sauce, String toppings) {
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

    public String getDescription() {
        return "Pizza with " + dough + " dough, " + sauce + " sauce, and " + toppings + " toppings.";
    }
}
