package payment;

public class PayPal extends paymentMethod {
    @Override
    public void processPayment(double amount){
        if (amount <= 0 || amount >= 100000){
            System.out.println("Ошибка: Сумма для оплаты должна быть больше нуля и не превышать 100000$");
            return;
        }
        System.out.println("Подключение к вашему аккаунту PayPal....");
        System.out.println("Успешное списание средств с PayPal" + amount);

        notifyAll(amount);
    }
}
