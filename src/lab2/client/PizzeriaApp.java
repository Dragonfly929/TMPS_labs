package lab2.client;

import lab2.Pizzeria;
import lab2.domain.factory.MargheritaPizzaMaker;
import lab2.domain.factory.PepperoniPizzaMaker;
import lab2.domain.factory.PizzaMaker;
import lab2.domain.models.*;

public class PizzeriaApp {
    public static void main(String[] args) throws CloneNotSupportedException {
        // Singleton Pattern
        Pizzeria pizzeria = Pizzeria.getInstance();

        // Builder Pattern
        PizzaBuilder builder = new PizzaBuilder()
                .setDough(Pizza.THIN_DOUGH)
                .setSauce(Pizza.TOMATO_SAUCE)
                .setToppings("Mozzarella cheese, Basil leaves");
        Pizza customPizza = builder.build();

        // Prototype Pattern
        CloneablePizza originalPizza = new CloneablePizza("Margherita");
        CloneablePizza clonedPizza = originalPizza.clone();
        System.out.println("Original Pizza Type: " + originalPizza.getType());
        System.out.println("Cloned Pizza Type: " + clonedPizza.getType());

        // Object Pooling Pattern
        PizzaPool pizzaPool = new PizzaPool(3);
        Pizza pizza1 = pizzaPool.acquire(Pizza.THIN_DOUGH, Pizza.TOMATO_SAUCE, "Mozzarella cheese, Basil leaves");
        Pizza pizza2 = pizzaPool.acquire(Pizza.THICK_DOUGH, Pizza.TOMATO_SAUCE, "Pepperoni, Cheese");
        pizzaPool.release(pizza1);
        Pizza pizza3 = pizzaPool.acquire(Pizza.THIN_DOUGH, Pizza.TOMATO_SAUCE, "Mushrooms, Olives");
        System.out.println("Pizzas: " + pizza1.getDescription() + ", " + pizza2.getDescription() + ", " + pizza3.getDescription());

        // Factory Method Pattern
        PizzaMaker margheritaPizzaMaker = new MargheritaPizzaMaker();
        Pizza margheritaPizza = margheritaPizzaMaker.createPizza();
        System.out.println("Margherita Pizza: " + margheritaPizza.getDescription());

        PizzaMaker pepperoniPizzaMaker = new PepperoniPizzaMaker();
        Pizza pepperoniPizza = pepperoniPizzaMaker.createPizza();
        System.out.println("Pepperoni Pizza: " + pepperoniPizza.getDescription());

        // Customer Interaction
        Customer customer = new Customer("John Doe", "555-123-4567");
        pizzeria.takeOrder(customer, "Margherita");

        // Implement the menu, order processing, and additional features here.
        // You can create a menu, manage orders, and interact with customers.
    }
}