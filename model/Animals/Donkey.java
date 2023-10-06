package model.Animals;

import java.time.LocalDate;
import java.util.ArrayList;

import model.Type;

public class Donkey extends Pack_animal{

    public Donkey(String name, LocalDate date, Type type, ArrayList<String> commands){
        super(name, date, type, commands);
    }
}