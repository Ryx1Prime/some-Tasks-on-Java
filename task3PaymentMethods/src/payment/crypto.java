package payment;

public class crypto extends paymentMethod{
    @Override
    public void processPayment(double amount){
        if (amount <= 0){
            System.out.println("Ошибка: Сумма транзакции не может быть отрицательной.");
            return;
        }
        System.out.println("Подтверждение транзакции в блокчейне...");
        System.out.println("Перевод " + amount + "$ в криптовалюте успешно завершен.");
    }
}
