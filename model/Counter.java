package model;

import java.io.Serializable;

public class Counter implements Serializable, Cloneable, AutoCloseable{
    private Integer counter;

    public Counter (){
        counter = 0;
    }
    
    public void addAnimal(){
        counter += 1;
    }

    public void printCount(){
        System.out.println("Общее колличество животных = " + counter);
    }

    @Override
    public void close() {
    }
}
