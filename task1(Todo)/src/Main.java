import control.controller;
import model.taskLst;
import view.userView;

public class Main {
    public static void main(String[] args) {
        taskLst model = new taskLst();
        userView view = new userView();
        controller control = new controller(model, view);

        control.run();
    }
}