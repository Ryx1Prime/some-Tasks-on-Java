import model.Client;
import model.Deal;
import model.DealStatus;
import model.Employee;
import service.CRM;

public class Main {
    public static void main(String[] args) {

        CRM myCrm = new CRM();

        Client client1 = new Client("555-0101", "Алексей", "alex@mail.com");
        Client client2 = new Client("555-0202", "Мария", "maria@mail.com");

        Employee manager = new Employee("Дмитрий", "Ведущий менеджер", 0.15);

        Deal dealA = new Deal(client1, manager, 100000, "Продажа лицензий ПО");
        Deal dealB = new Deal(client2, manager, 50000, "Настройка серверов");

        myCrm.addDeal(dealA);
        myCrm.addDeal(dealB);

        System.out.println("--- ТЕСТ УВЕДОМЛЕНИЙ ---");
        dealA.setStatus(DealStatus.IN_PROGRESS);
        dealB.setStatus(DealStatus.CLOSE_PLUS);

        System.out.println("\n--- СПИСОК СДЕЛОК (ДО СОРТИРОВКИ) ---");
        myCrm.printDeals();

        System.out.println("--- СПИСОК СДЕЛОК (ПОСЛЕ СОРТИРОВКИ ПО СТАТУСУ) ---");
        myCrm.sortStatuses();
        myCrm.printDeals();
    }
}