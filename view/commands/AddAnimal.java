package view.commands;

import view.View;

public class AddAnimal implements Command {
    private View view;

    public AddAnimal(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Добавить питомца";
    }

    @Override
    public void execute() {
        view.addAnimal();
    }
}
