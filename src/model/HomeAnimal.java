package model;

public class HomeAnimal extends Animal{
    private String typeAnimal;

    String getTypeAnimal() {
        return this.typeAnimal;
    }

    void setTypeAnimal(String name){
        this.typeAnimal = name;
    }
}
