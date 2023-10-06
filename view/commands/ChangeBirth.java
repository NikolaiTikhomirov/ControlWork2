package view.commands;

import view.View;

public class ChangeBirth implements Command {
    private View view;

    public ChangeBirth(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Изменить дату рождения питомца";
    }

    @Override
    public void execute() {
        view.addAnimal();
    }
}
