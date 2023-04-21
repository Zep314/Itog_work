package model;
import myexception.NotFullInformationException;

import java.util.Objects;

// класс - счетчик для добавления животных в список.
public class Counter {
    private int counter;

    public Counter() {
        counter = 0;
    }

    public int getCounter() {
        return counter;
    }

    // Если поля для заполнения информации о животном заполнены не полностью - вызываем исключение
    public void add(String animalName, String birthDate, String commands) throws NotFullInformationException {
        if (Objects.equals(animalName,"") | Objects.equals(birthDate,"") | Objects.equals(commands,"")) {
            throw new NotFullInformationException();
        }
        else {
            counter++;
        }
    }
}
