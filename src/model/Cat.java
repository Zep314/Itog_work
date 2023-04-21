package model;
// Класс данных для котов
public class Cat extends HomeAnimal {
    public Cat(String animalClass, String animalType, String animalName, String birthDate, String commands) {
        this.setAnimalClass(animalClass);
        this.setAnimalType(animalType);
        this.setName(animalName);
        this.setBirthDate(birthDate);
        this.setCommands(commands);
    }

}
