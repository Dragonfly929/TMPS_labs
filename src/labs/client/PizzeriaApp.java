package labs.client;

import labs.Pizzeria;
import labs.domain.builder.PizzaBuilder;
import labs.domain.factory.*;
import labs.domain.models.*;
import labs.domain.models.behavioral.*;
import labs.utilities.PizzaPool;

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
        PizzaMaker pepperoniPizzaMaker = new PepperoniPizzaMaker();

        // Bridge Pattern
        PizzaBridge margheritaBridge = new MargheritaPizzaBridge(margheritaPizzaMaker);
        PizzaBridge pepperoniBridge = new PepperoniPizzaBridge(pepperoniPizzaMaker);

        // Use the bridges to create custom pizzas
        Pizza customMargherita = margheritaBridge.makePizza();
        Pizza customPepperoni = pepperoniBridge.makePizza();

        // Decorator Pattern
        // Create a base custom pizza
        Pizza mushroomPizza = new PizzaBuilder()
                .setDough(Pizza.THIN_DOUGH)
                .setSauce(Pizza.TOMATO_SAUCE)
                .setToppings("Mozzarella cheese, Basil leaves")
                .build();

        // Decorate the custom pizza with extra toppings
        Pizza chickenMushroomPizza = new ExtraToppingsDecorator(mushroomPizza, "Mushrooms, Chicken");

        // Composite Pattern
        CompositePizza comboPizza = new CompositePizza("Thin", "Tomato", "Combo Pizza");
        comboPizza.addPizza(customMargherita);
        comboPizza.addPizza(customPepperoni);

        // Add an individual pizza to the combo pizza
        comboPizza.addPizza(chickenMushroomPizza);

        System.out.println("Custom Margherita Pizza: " + customMargherita.getDescription());
        System.out.println("Custom Pepperoni Pizza: " + customPepperoni.getDescription());
        System.out.println("Chicken Mushroom Pizza: " + chickenMushroomPizza.getDescription());
        System.out.println("Combo Pizza: " + comboPizza.getDescription());

        // Customer Interaction
        Customer customer = new Customer("Name Surname", "069-323-456");
        pizzeria.takeOrder(customer, "Combo Pizza");

        // Adapter
        PizzaV1 pizzaV1 = new PizzaV1("Thin Dough", "Tomato Sauce", "Mozzarella cheese, Basil leaves");
        PizzaV2 adaptedPizza = new PizzaV1Adapter(pizzaV1);

        System.out.println("Adapted Pizza: " + adaptedPizza.getDescription());

        // lab4
        // Observer
        Pizzeria pizzeriaa = Pizzeria.getInstance();

        Customer customer1 = new Customer("Lala Ho", "123-456-7890");
        Customer customer2 = new Customer("Alice Wonder", "987-654-3210");

        Order order1 = new Order("Margherita Pizza");
        Order order2 = new Order("Pepperoni Pizza");

        order1.addObserver(customer1);
        order2.addObserver(customer2);

        // Simulate pizza preparation
        // When pizzas are ready, call orderReady() on each order
        order1.orderReady();
        order2.orderReady();

        // Command design pattern
        // Create pizza orders
        Pizza margheritaPizza = margheritaPizzaMaker.createPizza();
        PizzaCommand margheritaCommand = new MargheritaPizzaCommand(margheritaPizza);

        Pizza pepperoniPizza = pepperoniPizzaMaker.createPizza();
        PizzaCommand pepperoniCommand = new PepperoniPizzaCommand(pepperoniPizza);

        // Execute pizza orders
        margheritaCommand.execute();
        pepperoniCommand.execute();

        // Strategy
        // Create payment strategies
        PaymentStrategy creditCardPayment = new CreditCardPaymentStrategy("1234", "Name Surname");
        PaymentStrategy cashPayment = new CashPaymentStrategy();
        PaymentStrategy onlinePayment = new OnlinePaymentStrategy("example@example.com");

        // create the payment context
        PaymentContext paymentContext = new PaymentContext();

        // set the payment strategy for the order
        paymentContext.setPaymentStrategy(creditCardPayment);

        // make the payment
        paymentContext.makePayment(20);

        // can change the payment strategy dynamically
        paymentContext.setPaymentStrategy(cashPayment);
        paymentContext.makePayment(15);
    }
}
