package presenter;

import java.time.LocalDate;
import java.util.ArrayList;

import model.Animals.Animal;
import model.Model;
import view.View;

public class Presenter {
    private View view;
    private Model model;

    public Presenter(View view, Model model){
        this.view = view;
        this.model = model;
        view.setPresenter(this);
    }

    public void addAnimal(Integer animalClass, String name, LocalDate date, ArrayList<String> commands){
        model.addAnimal(animalClass, name, date, commands);
    }

    public void getAnimalList(){
        view.print(model.getAnimalList());
    }

    public Animal getAnimal(String name){
        return model.getAnimal(name);
    }

    public void saveChanges() {
        model.saveChanges();
    }

    public void ChangeAnimal() {
        model.ChangeAnimal();
    }

    public void ChangeName(String name, String newName) {
        model.ChangeName(name, newName);
    }

    public void ChangeBirth() {
        model.ChangeBirth();
    }

    public void ChangeCommands() {
        model.ChangeCommands();
    }

    public void AddCommands() {
        model.AddCommands();
    }
}
