package model.Animals;

import java.time.LocalDate;
import java.util.ArrayList;


public class Cat extends Pet {

    public Cat(String name, LocalDate date, ArrayList<String> commands){
        super(name, date, commands);
    }
}