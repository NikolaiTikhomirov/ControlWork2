package model.Animals;

import java.time.LocalDate;
import java.util.ArrayList;


public class Dog extends Pet{
    
    static String animalKind = "Собака";

    public Dog(String name, LocalDate date, ArrayList<String> commands){
        super(animalKind, name, date, commands);
    }
}
