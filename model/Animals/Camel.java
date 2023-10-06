package model.Animals;

import java.time.LocalDate;
import java.util.ArrayList;

import model.Type;

public class Camel extends Pack_animal{

    public Camel(String name, LocalDate date, Type type, ArrayList<String> commands){
        super(name, date, type, commands);
    }
}