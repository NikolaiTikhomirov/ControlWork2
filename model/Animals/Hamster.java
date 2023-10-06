package model.Animals;

import java.time.LocalDate;
import java.util.ArrayList;


public class Hamster extends Pet{
    
    public Hamster(String name, LocalDate date, ArrayList<String> commands){
        super(name, date, commands);
    }
}