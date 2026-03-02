package obs;

public interface paymentObserver {
    void update(String paymentMethod, double amount);
}
