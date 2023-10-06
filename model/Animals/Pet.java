package model.Animals;

import java.time.LocalDate;
import java.util.ArrayList;

import model.Type;

public class Pet extends Animal{

    static Type type = Type.valueOf("pet");
    
    public Pet(String animalKind, String name, LocalDate date, ArrayList<String> commands) {
        super(animalKind, name, date, type, commands);
    }
}
