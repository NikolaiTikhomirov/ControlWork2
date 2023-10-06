package presenter;

import java.time.LocalDate;
import java.util.ArrayList;

import model.Type;
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

    public void saveChanges() {
        model.saveChanges();
    }
}
