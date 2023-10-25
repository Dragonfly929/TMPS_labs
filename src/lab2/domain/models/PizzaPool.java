package lab2.domain.models;

import java.util.ArrayList;
import java.util.List;

// Object Pooling Pattern
public class PizzaPool {
    private List<Pizza> pool;
    private int maxSize;

    public PizzaPool(int maxSize) {
        this.maxSize = maxSize;
        this.pool = new ArrayList<>(maxSize);
    }

    public Pizza acquire(String dough, String sauce, String toppings) {
        if (pool.isEmpty()) {
            return create(dough, sauce, toppings);
        }
        return pool.remove(0);
    }

    public void release(Pizza pizza) {
        if (pool.size() < maxSize) {
            pool.add(pizza);
        }
    }

    private Pizza create(String dough, String sauce, String toppings) {
        return new Pizza(dough, sauce, toppings);
    }
}