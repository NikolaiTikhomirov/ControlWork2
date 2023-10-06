package model.Animals;

import java.time.LocalDate;
import java.util.ArrayList;


public class Horse extends Pack_animal{
    
    static String animalKind = "Лошадь";

    public Horse(String name, LocalDate date, ArrayList<String> commands){
        super(animalKind, name, date, commands);
    }
}