package labs;

import labs.domain.models.behavioral.Customer;

// Singleton Pattern
public class Pizzeria {
    private static Pizzeria instance;

    private Pizzeria() {
        // Private constructor to prevent instantiation.
    }

    public static Pizzeria getInstance() {
        if (instance == null) {
            synchronized (Pizzeria.class) {
                if (instance == null) {
                    instance = new Pizzeria();
                }
            }
        }
        return instance;
    }

    public void takeOrder(Customer customer, String pizzaType) {
        System.out.println(customer.getName() + " ordered a " + pizzaType + " pizza.");
        // Process the order here.
        // You can implement order tracking, preparation, and delivery logic.
    }
}