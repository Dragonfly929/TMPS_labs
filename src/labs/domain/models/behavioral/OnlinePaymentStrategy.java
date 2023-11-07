// OnlinePaymentStrategy.java
package labs.domain.models.behavioral;

public class OnlinePaymentStrategy implements PaymentStrategy {
    private String email;

    public OnlinePaymentStrategy(String email) {
        this.email = email;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid $" + amount + " online via email: " + email);
    }
}
