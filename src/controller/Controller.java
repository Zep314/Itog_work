package controller;

// import model.DoublyList;
import view.View;

public class Controller {  // Контроллер
    private final View view;  // Вьювер

    public Controller() {
        this.view = new View();
    }
    public void run(){
        view.print("Hello!");
    }
}
