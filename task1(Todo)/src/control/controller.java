package control;

import model.taskLst;
import view.userView;

public class controller {
    private final taskLst taskList;
    private final userView view;

    public controller(taskLst taskList, userView view){
        this.taskList = taskList;
        this.view = view;
    }

    public void run(){
        int choice;
        do {
            view.mainMenu();
            choice = view.readChoice();

            switch (choice){
                case 1:
                    view.printTasks(taskList.getALLtasks(), "Все задачи:");
                    break;
                case 2:
                    String desc = view.readTaskDescription();
                    if (!desc.isEmpty()){
                        taskList.addTask(desc);
                        view.showNotification("Добавлена задача: " + desc);
                    }else{
                        view.showError("Описание не может быть пустым");
                    }
                    break;
                case 3:
                    if (taskList.size() == 0){
                        view.showError("Список пуст");
                        break;
                    }
                    view.printTasks(taskList.getALLtasks(), "Все задачи: ");
                    int num = view.readTaskNumber("удаления") - 1;
                    if (taskList.removeTask(num)){
                        view.showNotification("Задача удалена ");
                    }else{
                        view.showError("Неверный номер задачи");
                    }
                    break;
                case 4:
                    if (taskList.size() == 0) {
                        view.showError("Список пуст");
                        break;
                    }
                    view.printTasks(taskList.getALLtasks(), "Все задачи:");
                    int num1 = view.readTaskNumber("отметки как выполненной") - 1;
                    if (taskList.markDone(num1)) {
                        view.showNotification("Задача отмечена выполненной");
                    }else {
                        view.showError("Неверный номер задачи");
                    }
                    break;
                case 5 :
                    view.printTasks(taskList.getActiveTasks(), "Ваши активные задачи:");
                    break;
                case 6:
                    view.printTasks(taskList.getCompletedTasks(), "Ваши выполненные задачи:");
                    break;
                case 0:
                    view.goodbye();
                    break;
                default:
                    view.showError("Неверный выбор");
                    break;
            }
        }while (choice != 0);
        view.close();
    }
}