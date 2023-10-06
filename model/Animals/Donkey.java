package model.Animals;

import java.time.LocalDate;
import java.util.ArrayList;


public class Donkey extends Pack_animal{
    
    static String animalKind = "Осел";

    public Donkey(String name, LocalDate date, ArrayList<String> commands){
        super(animalKind, name, date, commands);
    }
}