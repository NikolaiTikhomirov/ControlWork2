package view.commands;

import view.View;

public class ChangeAnimal implements Command {
    private View view;

    public ChangeAnimal(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Изменить данные питомца";
    }

    @Override
    public void execute() {
        view.changeAnimal();
    }

    @Override
    public void executeChange(String name) {
    }
}
