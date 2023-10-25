package lab2.domain.models;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private Customer customer;
    private List<Pizza> pizzas;

    public Order(Customer customer) {
        this.customer = customer;
        this.pizzas = new ArrayList<>();
    }

    public void addPizza(Pizza pizza) {
        pizzas.add(pizza);
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public double calculateTotalCost() {
        double totalCost = 0;
        for (Pizza pizza : pizzas) {
            // Add the cost of each pizza to the total.
            // You can define a pricing mechanism for different pizza types and toppings.
            totalCost += calculatePizzaCost(pizza);
        }
        return totalCost;
    }

    private double calculatePizzaCost(Pizza pizza) {
        // Define the cost calculation for each pizza type and toppings.
        // For simplicity, let's assume a fixed cost for all pizzas.
        return 10.0;
    }
}
