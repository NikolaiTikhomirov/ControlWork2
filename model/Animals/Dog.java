package model.Animals;

import java.time.LocalDate;
import java.util.ArrayList;


public class Dog extends Pet{

    public Dog(String name, LocalDate date, ArrayList<String> commands){
        super(name, date, commands);
    }
}
