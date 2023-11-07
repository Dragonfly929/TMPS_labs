// CreditCardPaymentStrategy.java
package labs.domain.models.behavioral;

public class CreditCardPaymentStrategy implements PaymentStrategy {
    private String cardNumber;
    private String name;

    public CreditCardPaymentStrategy(String cardNumber, String name) {
        this.cardNumber = cardNumber;
        this.name = name;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid $" + amount + " with Credit Card ending in " + cardNumber);
    }
}
