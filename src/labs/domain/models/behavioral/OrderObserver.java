package labs.domain.models.behavioral;

public interface OrderObserver {
    void update(Order order);
}
