package model;

public class Animal {
    private String animalClass;
    private String name;
    private String birthDate;
    private String commands;

    public String getAnimalClass() {
        return animalClass;
    }
    public void setAnimalClass(String name){
        this.animalClass = name;
    };

    public String getName() {
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getCommands() {
        return this.commands;
    }

    public void setCommands(String commands) {
        this.commands = commands;
    }
}
