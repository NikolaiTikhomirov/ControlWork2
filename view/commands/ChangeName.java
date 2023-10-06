package view.commands;

import view.View;

public class ChangeName implements Command {
    private View view;

    public ChangeName(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Изменить имя питомца";
    }

    @Override
    public void execute() {
        view.addAnimal();
    }
}
