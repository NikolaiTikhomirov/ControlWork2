package model.Animals;

import java.time.LocalDate;
import java.util.ArrayList;

import model.Type;

public class Pack_animal extends Animal{

    static Type type = Type.valueOf("pack_animal");
    
    public Pack_animal(String animalKind, String name, LocalDate date, ArrayList<String> commands) {
        super(animalKind, name, date, type, commands);
    }
}
