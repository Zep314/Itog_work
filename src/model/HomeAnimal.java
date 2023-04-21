package model;
// Класс данных для домашних животных
public class HomeAnimal extends Animal {
    private String animalType;

    public String getAnimalType() {
        return this.animalType;
    }

    public void setAnimalType(String name){
        this.animalType = name;
    }
}
