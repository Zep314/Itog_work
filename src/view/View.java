package view;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import model.*;

public class View { // Класс вьювер - отображение на экране и взаимодействие с пользователем
    private final Logger log = Logger.getLogger(View.class.getName());  // Логи

    public View() {
        try {  // Инициализация логгера
            LogManager.getLogManager().readConfiguration( // берем конфиг для логов
                    View.class.getResourceAsStream("../log.config"));
        } catch (IOException e) {  // печаль, беда...
            System.err.println("Could not setup logger configuration: " + e.getMessage());
        }
    }
    public void printInfo(String string) {
        log.info(string);  // Выводим информацию в лог
    }
    public void printWarning(String string) {
        log.warning(string);  // Выводим warning в лог
    }

    public void printHelp() {
        this.printInfo("Программа имитирующая работу реестра домашних животных");
        this.printInfo("Список комманд:");
        this.printInfo("q - выход из программы");
        this.printInfo("h - вывод этой помощи");
        this.printInfo("a - добавить новое животное");
        this.printInfo("l - посмотреть весь список животных");
        this.printInfo("v - посмотреть список команд одного животного");
        this.printInfo("t - научить новым командам одно животное");
    }

    public int question(String question) {
        Scanner scan = new Scanner(System.in);
        String inputLine = "";
        this.printInfo(question);
        inputLine = scan.nextLine();
        switch (inputLine) {
            case("1"):
                return 1;
            case("2"):
                return 2;
            case("3"):
                return 3;
            default:
                return 0;
        }
    }

    private void printLine() {
        this.printInfo(String.format("+%2s+%8s+%15s+%10s+%10s+%10s+%30s+"
                , "-".repeat(2)
                , "-".repeat(8)
                , "-".repeat(15)
                , "-".repeat(10)
                , "-".repeat(10)
                , "-".repeat(10)
                , "-".repeat(30)
                ));
    }
    public void printDB(ArrayList<Animal> animalList) {
        if (animalList.size() > 0) {
            int i = 1;
            this.printLine();
            this.printInfo(String.format("|%2s|%8s|%15s|%10s|%10s|%10s|%30s|"
                    , "#"
                    , "Животное"
                    , "Принадлежность"
                    , "Тип"
                    , "Кличка"
                    , "Дата рожд."
                    , "Команды"
            ));

            this.printLine();
            for (Animal animal: animalList) {
                this.printInfo(String.format("|%2d|%8s|%15s|%10s|%10s|%10s|%30s|"
                        , i
                        , animal.getClass().getSimpleName()
                        , animal.getAnimalClass()
                        , Objects.equals(animal.getClass().getSuperclass().getSimpleName(),"HomeAnimal") ? "Домашние" : "Вьючные"
                        , animal.getName()
                        , animal.getBirthDate()
                        , animal.getCommands()
                        ));
                i++;
            }
            this.printLine();
        }
        else {
            this.printWarning("Список животных пуст! Нечего выводить!");
        }
    }

}
