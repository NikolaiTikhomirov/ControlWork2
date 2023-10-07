package view;

import presenter.Presenter;

public interface View {
    void print(String text);
    void start();
    void setPresenter(Presenter presenter);
    void addAnimal();
    void getAnimalList();
    void changeAnimal();
    void changeName(String name);
    void changeBirth(String name);
    void changeCommands(String name);
    void addCommands(String name);
    void saveChanges();
    void finish();
}
