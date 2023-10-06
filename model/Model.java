package model;

import java.time.LocalDate;
import java.util.ArrayList;

import model.Animals.Animal;
import model.Animals.Camel;
import model.Animals.Cat;
import model.Animals.Dog;
import model.Animals.Donkey;
import model.Animals.Hamster;
import model.Animals.Horse;
import model.fileHandler.Writable;

public class Model {
    private AnimalList<String, Animal> animalList;
    private String animalListPath;
    private Writable writable;

    public Model(Writable writable) {
        animalListPath = "model/animalList.txt";
        this.writable = writable;
        animalList = (AnimalList<String, Animal>) writable.read(animalListPath);
    }

    public void addAnimal(Integer animalClass, String name, LocalDate date, Type type, ArrayList<String> commands) {
        Animal animal = null;
        if (animalClass == 1){
            animal = new Dog(name, date, type, commands);
        }
        if (animalClass == 2){
            animal = new Cat(name, date, type, commands);
        }
        if (animalClass == 3){
            animal = new Hamster(name, date, type, commands);
        }
        if (animalClass == 4){
            animal = new Horse(name, date, type, commands);
        }
        if (animalClass == 5){
            animal = new Camel(name, date, type, commands);
        }
        if (animalClass == 6){
            animal = new Donkey(name, date, type, commands);
        }
        
        animalList.addAnimal(animal);
    }

    public String getAnimalList() {
        return animalList.getInfo();
    }

    public void saveChanges() {
        writable.save(animalList, animalListPath);
    }

}
