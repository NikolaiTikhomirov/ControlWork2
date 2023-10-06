package model.Animals;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

import model.AnimalListInterface;
import model.Type;

public class Donkey extends Pack_animal implements Serializable, AnimalListInterface{

    // private String name;
    // private LocalDate date;
    // private Type type;
    // private ArrayList<String> commands;

    public Donkey(String name, LocalDate date, Type type, ArrayList<String> commands){
        super(name, date, type, commands);
        // this.name = name;
        // this.date = date;
        // this.type = type;
        // this.commands = commands;
    }

    // @Override
    // public String getName(){
    //     return name;
    // }

    // @Override
    // public LocalDate getDate(){
    //     return date;
    // }

    // @Override
    // public Type getType(){
    //     return type;
    // }

    // @Override
    // public String getCommands(){
    //     String res = "";
    //     for (String str : commands) {
    //         res += str;
    //     }
    //     return res;
    // }

    // public String toString() {
    //     String n = "";
    //     String d = "";
    //     String t = "";
    //     String c = "";
    //     if (name != null) n = this.getName();
    //     if (date != null) d = String.valueOf(this.getDate());
    //     if (type != null) t = String.valueOf(this.getType());
    //     if (commands != null) c = String.valueOf(this.getCommands());
    //     return "Имя: " + n + " Дата рождения: " + d + " вид животного: " + t + " комманды: " + c;
    // }

    // public String getInfo() {
    //     String n = "";
    //     String d = "";
    //     String t = "";
    //     String c = "";
    //     if (name != null) n = this.getName();
    //     if (date != null) d = String.valueOf(this.getDate());
    //     if (type != null) t = String.valueOf(this.getType());
    //     if (commands != null) c = String.valueOf(this.getCommands());
    //     return n + " " + d + " " + t + " " + c;
    // }
}
