package model;

public class Dog extends HomeAnimal{
    public Dog(String animalClass, String animalType, String animalName, String birthDate, String commands) {
        this.setAnimalClass(animalClass);
        this.setAnimalType(animalType);
        this.setName(animalName);
        this.setBirthDate(birthDate);
        this.setCommands(commands);
    }
}
