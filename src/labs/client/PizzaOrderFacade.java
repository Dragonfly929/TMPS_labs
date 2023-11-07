package labs.client;

import labs.Pizzeria;
import labs.domain.builder.PizzaBuilder;
import labs.domain.factory.MargheritaPizzaMaker;
import labs.domain.factory.PizzaMaker;
import labs.domain.models.Pizza;
import labs.domain.models.behavioral.Customer;

public class PizzaOrderFacade {
    private PizzaBuilder pizzaBuilder;
    private PizzaMaker pizzaMaker;
    private Pizzeria pizzeria;

    public PizzaOrderFacade() {
        this.pizzaBuilder = new PizzaBuilder();
        this.pizzaMaker = new MargheritaPizzaMaker();
        this.pizzeria = Pizzeria.getInstance();
    }

    public void orderCustomPizza(String dough, String sauce, String toppings) {
        Pizza customPizza = pizzaBuilder.setDough(dough).setSauce(sauce).setToppings(toppings).build();
        Customer customer = new Customer("Name Surname", "069-323-456");
        pizzeria.takeOrder(customer, "Custom Pizza");
    }

    public void orderMargheritaPizza() {
        Pizza margheritaPizza = pizzaMaker.createPizza();
        Customer customer = new Customer("Hey Yo", "069-323-654");
        pizzeria.takeOrder(customer, "Margherita");
    }

    // more methods to order different types of pizzas here

    // Other methods to interact with the pizza system

    public static void main(String[] args) {
        PizzaOrderFacade pizzaOrderFacade = new PizzaOrderFacade();

        // Use the facade to place orders
        pizzaOrderFacade.orderCustomPizza("Thin", "Tomato", "Mozzarella cheese, Basil leaves");
        System.out.println("Ordered Custom Pizza");

        pizzaOrderFacade.orderMargheritaPizza();
        System.out.println("Ordered Margherita Pizza");
    }
}
