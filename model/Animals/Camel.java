package model.Animals;

import java.time.LocalDate;
import java.util.ArrayList;


public class Camel extends Pack_animal{

    static String animalKind = "Верблюд";

    public Camel(String name, LocalDate date, ArrayList<String> commands){
        super(animalKind, name, date, commands);
    }
}