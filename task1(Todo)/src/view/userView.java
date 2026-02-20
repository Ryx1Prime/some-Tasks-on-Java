package view;

import model.taskLst;

import java.util.List;
import java.util.Scanner;

public class userView {
    private final Scanner scanner;

    public userView(){
        scanner = new Scanner(System.in);
    }

    public void mainMenu(){
        System.out.println("\n=== TO-DO LIST ===");
        System.out.println("1. Показать все задачи");
        System.out.println("2. Добавить задачу");
        System.out.println("3. Удалить задачу");
        System.out.println("4. Отметить как выполненную");
        System.out.println("5. Показать активные задачи");
        System.out.println("6. Показать выполненные задачи");
        System.out.println("0. Выход");
        System.out.print("Выберите действие: ");
    }

    public int readChoice() {
        while (true) {
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.print("Пожалуйста, введите корректное число: ");
            }
        }
    }

    public String readTaskDescription() {
        System.out.print("Введите описание задачи: ");
        return scanner.nextLine().trim();
    }

    public int readTaskNumber(String action) {
        System.out.print("Номер задачи для " + action + ": ");
        while (true) {
            String input = scanner.nextLine().trim();
            try {
                int num = Integer.parseInt(input);
                if (num < 1) {
                    System.out.print("Номер должен быть положительным: ");
                    continue;
                }
                return num;
            } catch (NumberFormatException e) {
                System.out.print("Введите корректный номер: ");
            }
        }
    }

    public void printTasks(List<taskLst.OneTask> tasks, String header){
        System.out.println("\n" + header);
        if (tasks.isEmpty()){
            System.out.println("Список пуст.");
            return;
        }
        for (int i = 0; i < tasks.size(); i++){
            System.out.printf("%d) %s%n", i + 1, tasks.get(i));

        }
    }
    public void showNotification(String message){
        System.out.println("[Уведомление] " + message);
    }
    public void showError(String message){
        System.out.println("[Ошибка] " + message);
    }
    public void goodbye(){
        System.out.println("До свидания!");
    }
    public void close(){
        scanner.close();
    }



}
