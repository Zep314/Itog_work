package controller;

import model.*;
import view.View;

import java.util.ArrayList;
import java.util.Scanner;

public class Controller {  // Контроллер
    private final View viewer;  // Вьювер
    private Counter counter;
    private ArrayList<Animal> animalList;

    public Controller() {
        this.viewer = new View();
        this.animalList = new ArrayList<Animal>();
        this.counter = new Counter();
    }

    private void addAnimal() {
        this.viewer.printInfo("Добавление животного в базу");
        int answer;
        Animal animal = null;
        this.viewer.printInfo("Добавление животного");
        answer = this.viewer.question("Какое животное хотите добавить? (1-домашнее; 2-вьючное):");
        switch (answer) {
            case(1):
                answer = this.viewer.question("Какое животное хотите добавить? (1-кот; 2-собака; 3-хомяк):");
                switch (answer) {
                    case(1):
                        animal = new Cat("Мои животные","Домашние","","","");
                        break;
                    case(2):
                        animal = new Dog("Мои животные","Домашние","","","");
                        break;
                    case(3):
                        animal = new Hamster("Мои животные","Домашние","","","");
                        break;
                    default:
                        this.viewer.printWarning("Ошибка ввода.");
                        break;
                }
                break;
            case(2):
                answer = this.viewer.question("Какое животное хотите добавить? (1-конь; 2-верблюд; 3-осел):");
                switch (answer) {
                    case(1):
                        animal = new Horse("Мои животные","Вьючные","","","");
                        break;
                    case(2):
                        animal = new Camel("Мои животные","Вьючные","","","");
                        break;
                    case(3):
                        animal = new Donkey("Мои животные","Вьючные","","","");

                        break;
                    default:
                        this.viewer.printWarning("Ошибка ввода.");
                        break;
                }
                break;
            default :
                this.viewer.printWarning("Ошибка ввода.");
                break;
        }
        if (animal != null) {
            Scanner scan = new Scanner(System.in);
            this.viewer.printInfo("Введите кличку Вашего животного:");
            animal.setName(scan.nextLine());
            this.viewer.printInfo("Введите дату рождения животного:");
            animal.setBirthDate(scan.nextLine());
            this.viewer.printInfo("Введите команды, которые знает Ваше животное:");
            animal.setCommands(scan.nextLine());
            this.animalList.add(animal);
            this.counter.add();
            this.viewer.printInfo("Животное добавлено в базу.");
        }
    }

    private void printCommands() {
        this.viewer.printInfo("Печать команд, которые умеет выполнять животное");
        this.viewer.printInfo("Введите номер животного в списке:");
        Scanner scan = new Scanner(System.in);
        int num = 0;
        try {
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

    private void train() {
        this.viewer.printInfo("Обучение животного новым командам.");
        this.viewer.printInfo("Введите номер животного в списке:");
        Scanner scan = new Scanner(System.in);
        String inputLine = "";
        int num = 0;
        try {
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
        viewer.printInfo("Hello!");
        this.viewer.printInfo("Начало работы!");

        animalList.add(new Cat("Мои животные","Домашние","Барсик","22-01-2022","спать"));
        animalList.add(new Dog("Мои животные","Домашние","Макс","11-10-2019","гулять"));
        animalList.add(new Donkey("Мои животные","Вьючные","Яша","01-06-2015","стой"));
        animalList.add(new Horse("Мои животные","Вьючные","Боливар","21-08-2013","вперед"));


        boolean exit = false;
        Scanner scan = new Scanner(System.in);
        String inputLine = "";
        while (!exit) {
            this.viewer.printInfo("Введите команду (h - для вывода помощи): ");
            inputLine = scan.nextLine();
            switch (inputLine) {
                case ("q"):
                    exit = true;
                    break;
                case ("h"):
                    this.viewer.printHelp();
                    break;
                case ("a"):
                    this.addAnimal();
                    break;
                case ("l"):
                    this.viewer.printInfo("Печать списка животных");
                    this.viewer.printDB(this.animalList);
                    break;
                case ("v"):
                    this.printCommands();
                    break;
                case ("t"):
                    this.train();
                    break;
                default:
                    this.viewer.printInfo("Неопределенная команда.");
                    break;
            }
        }
        this.viewer.printInfo("Работа завершена.");
    }
}
