package model.Animals;

import java.time.LocalDate;
import java.util.ArrayList;

import model.Type;

public class Pack_animal extends Animal{
    
    public Pack_animal(String name, LocalDate date, Type type, ArrayList<String> commands) {
        super(name, date, type, commands);
    }
}
