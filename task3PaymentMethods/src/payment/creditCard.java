package payment;

public class creditCard extends paymentMethod{

    @Override
    public void processPayment(double amount){
        if (amount <= 0 || amount >= 100000){
            System.out.println("Ошибка: Сумма для оплаты должна быть больше нуля и не превышать 100000$");
            return;
        }
        System.out.println("Проверка баланса вашей карты");
        System.out.println("Списание: $" + amount + " с кредитной карты произведено успешно!");

        notifyAll(amount);
    }
}
