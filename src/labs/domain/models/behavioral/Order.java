package labs.domain.models.behavioral;

import java.util.ArrayList;
import java.util.List;

public class Order implements OrderObserver {
    private String orderName;
    private List<OrderObserver> observers = new ArrayList<>();

    public Order(String orderName) {
        this.orderName = orderName;
    }

    public void addObserver(OrderObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(OrderObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (OrderObserver observer : observers) {
            observer.update(this);
        }
    }

    public void orderReady() {
        System.out.println(orderName + " is ready for pickup!");
        notifyObservers();
    }

    @Override
    public void update(Order order) {
        System.out.println("Customer received a notification: " + order.getOrderName() + " is ready for pickup.");
    }

    public String getOrderName() {
        return orderName;
    }
}
