package labs.domain.models.behavioral;

public class Customer implements OrderObserver {
    private String name;
    private String phoneNumber;

    public Customer(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public void update(Order order) {
        System.out.println("Customer " + name + " received a notification: " + order.getOrderName() + " is ready for pickup.");
    }
}
