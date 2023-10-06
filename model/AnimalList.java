package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import model.AnimalList;
import model.Animals.Animal;

public class AnimalList<String, T extends AnimalListInterface> implements Serializable, Iterable<T>{
    private HashMap<String, Animal> animalList;

    public AnimalList(){
        animalList = new HashMap<String, Animal>();
    }

    public void addAnimal(Animal animal){
        animalList.put((String) animal.getName(), animal);
    }

    public String getInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        for (var pair: animalList.entrySet()) {
            stringBuilder.append(pair.getValue());
            stringBuilder.append("\n");
        }
        return (String) stringBuilder.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return ((Iterable<T>) animalList).iterator();
    }

    public Animal getAnimal(String name){
        return animalList.get(name);
    }

    public Collection<Animal> getValues(){
        return animalList.values();
    }

    public void removeAnimal(String name){
        animalList.remove(name);
    }

    public Integer size(){
        return animalList.size();
    }
}
