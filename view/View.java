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
    void changeBirth();
    void changeCommands();
    void addCommands();
    void saveChanges();
    void finish();
}
