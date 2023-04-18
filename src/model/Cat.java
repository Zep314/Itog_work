package model;

public class Cat extends HomeAnimal{
    private String name;
    private String birthDate;
    private String commands;

    public Cat() {

    }
    String getName() {
        return this.name;
    }

    void setName(String name){
        this.name = name;
    }

    String getBirthDate() {
        return this.birthDate;
    }

    void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    String getCommands() {
        return this.commands;
    }

    void setCommands(String commands) {
        this.commands = commands;
    }

}
