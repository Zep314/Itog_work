package model;
// Класс данных для вьючных животных
public class PackAnimal extends Animal {
    private String animalType;

    public String getAnimalType() {
        return this.animalType;
    }

    public void setAnimalType(String name){
        this.animalType = name;
    }
}
