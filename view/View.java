package view;

import presenter.Presenter;

public interface View {
    void print(String text);
    void start();
    void setPresenter(Presenter presenter);
    void addAnimal();
    void getAnimalList();
    void ChangeAnimal();
    void ChangeName(String name);
    void ChangeBirth();
    void ChangeCommands();
    void AddCommands();
    void saveChanges();
    void finish();
}
