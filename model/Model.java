package model;

import java.time.LocalDate;
import java.util.ArrayList;

import model.Animals.Animal;
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

    public void addAnimal(String name, LocalDate date, Type type, ArrayList<String> commands) {
        Animal animal = new Animal(name, date, type, commands);
        animalList.addAnimal(animal);
    }

    public String getAnimalList() {
        return animalList.getInfo();
    }

    public void saveChanges() {
        writable.save(animalList, animalListPath);
    }

}
