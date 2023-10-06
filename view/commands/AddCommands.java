package view.commands;

import view.View;

public class AddCommands implements Command {
    private View view;

    public AddCommands(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Добавить питомцу команд команд";
    }

    @Override
    public void execute() {
        view.addAnimal();
    }
}
