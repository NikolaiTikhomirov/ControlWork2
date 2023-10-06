package model.Animals;

import java.time.LocalDate;
import java.util.ArrayList;


public class Horse extends Pack_animal{

    public Horse(String name, LocalDate date, ArrayList<String> commands){
        super(name, date, commands);
    }
}