package model.Animals;

import java.time.LocalDate;
import java.util.ArrayList;


public class Cat extends Pet {

    static String animalKind = "Кот";

    public Cat(String name, LocalDate date, ArrayList<String> commands){
        super(animalKind, name, date, commands);
    }
}