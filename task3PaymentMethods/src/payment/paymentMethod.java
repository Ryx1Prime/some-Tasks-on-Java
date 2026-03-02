package payment;

import obs.paymentObserver;

import java.util.ArrayList;
import java.util.List;

public abstract class paymentMethod {
    private List<paymentObserver> observers = new ArrayList<>();
    public void addObserver(paymentObserver obs){
        observers.add(obs);
    }
    protected void notifyAll(double amount){
        for(paymentObserver obs : observers){
            obs.update(this.getClass().getSimpleName(), amount);
        }
    }
    public abstract void processPayment(double amount);
}
