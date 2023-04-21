package controller;

import model.*;
import view.View;
import myexception.NotFullInformationException;

import java.util.ArrayList;
import java.util.Scanner;

// Класс контроллера - тут все и происходит
public class Controller {
    private final View viewer;  // Вьювер
    private final Counter counter;  // Счетчик животных в списке
    private final ArrayList<Animal> animalList;  // список животных

    public Controller() {  // Инициализация
        this.viewer = new View();
        this.animalList = new ArrayList<>();
        this.counter = new Counter();
    }

    private void addAnimal() {  // Добавление животного в базу
        this.viewer.printInfo("Добавление животного в базу");
        int answer;
        Animal animal = null;
        this.viewer.printInfo("Добавление животного");
        answer = this.viewer.question("Какое животное хотите добавить? (1-домашнее; 2-вьючное):");
        switch (answer) {  // Задаем вопросы, чтобы правильно определить животное в структуру данных
            case (1) -> {
                answer = this.viewer.question("Какое животное хотите добавить? (1-кот; 2-собака; 3-хомяк):");
                switch (answer) {
                    case (1) -> animal = new Cat("Мои животные", "Домашние", "", "", "");
                    case (2) -> animal = new Dog("Мои животные", "Домашние", "", "", "");
                    case (3) -> animal = new Hamster("Мои животные", "Домашние", "", "", "");
                    default -> this.viewer.printWarning("Ошибка ввода.");
                }
            }
            case (2) -> {
                answer = this.viewer.question("Какое животное хотите добавить? (1-конь; 2-верблюд; 3-осел):");
                switch (answer) {
                    case (1) -> animal = new Horse("Мои животные", "Вьючные", "", "", "");
                    case (2) -> animal = new Camel("Мои животные", "Вьючные", "", "", "");
                    case (3) -> animal = new Donkey("Мои животные", "Вьючные", "", "", "");
                    default -> this.viewer.printWarning("Ошибка ввода.");
                }
            }
            default -> this.viewer.printWarning("Ошибка ввода.");
        }
        if (animal != null) {  // Вводим недостающую информацию
            Scanner scan = new Scanner(System.in);
            this.viewer.printInfo("Введите кличку Вашего животного:");
            animal.setName(scan.nextLine());
            this.viewer.printInfo("Введите дату рождения животного:");
            animal.setBirthDate(scan.nextLine());
            this.viewer.printInfo("Введите команды, которые знает Ваше животное:");
            animal.setCommands(scan.nextLine());
            try {  // Записываем информацию в список, с проверкой о ее полноте
                this.counter.add(animal.getName(),animal.getBirthDate(),animal.getCommands());
                this.animalList.add(animal);  // тут проверка на полноту информации
                this.viewer.printInfo("Животное добавлено в базу.");
                this.viewer.printInfo(String.format("Всего в базе %d животных.", counter.getCounter()));
            } catch (NotFullInformationException e) {
                this.viewer.printWarning("Ошибка добавления! Заполнены не все поля!");
            }
        }
    }

    private void printCommands() {  // Печать команд, которые умеет выполнять животное
        this.viewer.printInfo("Печать команд, которые умеет выполнять животное");
        this.viewer.printInfo("Введите номер животного в списке:");
        Scanner scan = new Scanner(System.in);
        int num;
        try {  // Проверка на корректность ввода номера животного в списке
            num = Integer.parseInt(scan.nextLine());
        } catch (Exception e) {
            this.viewer.printWarning(String.format("Ошибка ввода, %s",e.getMessage()));
            return;
        }
        if ((num > 0) & (num <= animalList.size())) {
            Animal animal = animalList.get(num - 1);
            this.viewer.printInfo(String.format("Животное: %s", animal.getClass().getSimpleName()));
            this.viewer.printInfo(String.format("Кличка: %s", animal.getName()));
            this.viewer.printInfo(String.format("Команды: %s", animal.getCommands()));
        }
        else {
            this.viewer.printWarning("Животного с таким номером нет!");
        }
    }

    private void train() {  // Обучение животного новым командам
        this.viewer.printInfo("Обучение животного новым командам.");
        this.viewer.printInfo("Введите номер животного в списке:");
        Scanner scan = new Scanner(System.in);
        int num;
        try {  // Проверка на корректность ввода номера животного в списке
            num = Integer.parseInt(scan.nextLine());
        } catch (Exception e) {
            this.viewer.printWarning(String.format("Ошибка ввода, %s",e.getMessage()));
            return;
        }
        if ((num > 0) & (num <= animalList.size())) {
            Animal animal = animalList.get(num - 1);
            this.viewer.printInfo(String.format("Животное: %s", animal.getClass().getSimpleName()));
            this.viewer.printInfo(String.format("Введите новый список команд, которые знает %s:", animal.getName()));
            animal.setCommands(scan.nextLine());
            this.viewer.printInfo("Новые команды записаны!");
        }
        else {
            this.viewer.printWarning("Животного с таким номером нет!");
        }
    }
    public void run(){
        this.viewer.printInfo("Начало работы!");

        // Для отладки!
//        animalList.add(new Cat("Мои животные","Домашние","Барсик","22-01-2022","спать"));
//        animalList.add(new Dog("Мои животные","Домашние","Макс","11-10-2019","гулять"));
//        animalList.add(new Donkey("Мои животные","Вьючные","Яша","01-06-2015","стой"));
//        animalList.add(new Horse("Мои животные","Вьючные","Боливар","21-08-2013","вперед"));

        boolean exit = false;
        Scanner scan = new Scanner(System.in);
        String inputLine;
        while (!exit) {  // Главный цикл программы
            this.viewer.printInfo("Введите команду (h - для вывода помощи): ");
            inputLine = scan.nextLine();
            switch (inputLine) {
                case ("q") -> exit = true;                                 // Выход из программы
                case ("h") -> this.viewer.printHelp();                     // Печать помощи
                case ("a") -> this.addAnimal();                            // Добавление нового животного в список
                case ("l") -> {                                            // Печать списка животных
                    this.viewer.printInfo("Печать списка животных");
                    this.viewer.printDB(this.animalList);
                }
                case ("v") -> this.printCommands();                        // Печать команд, которые знает животное
                case ("t") -> this.train();                                // Запись новых команд, которые знает животное
                default -> this.viewer.printInfo("Неопределенная команда.");  // Если ввод не распознан
            }
        }
        this.viewer.printInfo("Работа завершена.");
    }
}
