package model.Animals;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

import model.AnimalListInterface;
import model.Type;

public class Animal implements Serializable, AnimalListInterface{
    
    private String animalKind;
    private String name;
    private LocalDate date;
    private Type type;
    private ArrayList<String> commands;

    public Animal(String animalKind, String name, LocalDate date, Type type, ArrayList<String> commands){
        this.animalKind = animalKind;
        this.name = name;
        this.date = date;
        this.type = type;
        this.commands = commands;
    }

    public String getAnimalKind(){
        return animalKind;
    }

    public String getName(){
        return name;
    }

    public LocalDate getDate(){
        return date;
    }

    public Type getType(){
        return type;
    }

    public String getCommands(){
        String res = "";
        for (String str : commands) {
            res += str + " ";
        }
        return res;
    }

    public void setName(String newName){
        name = newName;
    }

    public void setDate(LocalDate newDate){
        this.date = newDate;
    }

    public void setCommands(ArrayList<String> newCommands){
        this.commands = newCommands;
    }

    public void addCommands(ArrayList<String> newCommands){
        for (String str : commands) {
            this.commands.add(str);
        }
    }

    public String toString() {
        String a = "";
        String n = "";
        String d = "";
        String t = "";
        String c = "";
        if (animalKind != null) a = this.getAnimalKind();
        if (name != null) n = this.getName();
        if (date != null) d = String.valueOf(this.getDate());
        if (type != null) t = String.valueOf(this.getType());
        if (commands != null) c = String.valueOf(this.getCommands());
        return "Вид животного: " + a + "Имя: " + n + " Дата рождения: " + d + " класс животного: " + t + " комманды: " + c;
    }

    public String getInfo() {
        String a = "";
        String n = "";
        String d = "";
        String t = "";
        String c = "";
        if (animalKind != null) a = this.getAnimalKind();
        if (name != null) n = this.getName();
        if (date != null) d = String.valueOf(this.getDate());
        if (type != null) t = String.valueOf(this.getType());
        if (commands != null) c = String.valueOf(this.getCommands());
        return a + " " + n + " " + d + " " + t + " " + c;
    }
}