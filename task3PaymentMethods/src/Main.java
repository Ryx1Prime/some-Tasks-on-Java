import factory.paymentFactory;
import obs.paymentObserver;
import payment.paymentMethod;

import java.util.Scanner;

public class Main implements paymentObserver {

    @Override
    public void update(String paymentMethodName, double amount) {
        System.out.println("--> НАБЛЮДАТЕЛЬ ПОЛУЧИЛ СИГНАЛ: Совершен платеж методом "
                + paymentMethodName + " на сумму " + amount + "$");
    }

    public static void main(String[] args) {
        Main notificationSystem = new Main();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===========================");
            System.out.println("Выберите способ оплаты:");
            System.out.println("1) Кредитная карта (Credit Card)");
            System.out.println("2) PayPal");
            System.out.println("3) Криптовалюта (Crypto)");
            System.out.println("0) Выход из программы");
            System.out.print("Ваш выбор: ");
            int choice = scanner.nextInt();

            if (choice == 0) {
                System.out.println("Завершение работы программы. До свидания!");
                break;
            }

            String paymentType = "";
            switch (choice) {
                case 1:
                    paymentType = "credit_card";
                    break;
                case 2:
                    paymentType = "paypal";
                    break;
                case 3:
                    paymentType = "crypto";
                    break;
                default:
                    System.out.println("Ошибка: Неверный пункт меню. Попробуйте еще раз.");
                    continue;
            }
            System.out.print("Введите сумму для оплаты: ");
            double amount = scanner.nextDouble();
            System.out.println("\n--- Обработка транзакции ---");

            try {
                paymentMethod payment = paymentFactory.createPaymentMethod(paymentType);
                payment.addObserver(notificationSystem);
                payment.processPayment(amount);
            } catch (Exception e) {
                System.out.println("Произошла системная ошибка: " + e.getMessage());
            }
        }

        scanner.close();
    }
}