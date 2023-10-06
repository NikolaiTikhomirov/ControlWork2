package model.Animals;

import java.time.LocalDate;
import java.util.ArrayList;


public class Hamster extends Pet{
    
    static String animalKind = "Хомяк";
    
    public Hamster(String name, LocalDate date, ArrayList<String> commands){
        super(animalKind, name, date, commands);
    }
}