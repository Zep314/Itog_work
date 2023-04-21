package model;
// Класс данных для хомяков
public class Hamster extends HomeAnimal {
    public Hamster(String animalClass, String animalType, String animalName, String birthDate, String commands) {
        this.setAnimalClass(animalClass);
        this.setAnimalType(animalType);
        this.setName(animalName);
        this.setBirthDate(birthDate);
        this.setCommands(commands);
    }
}
