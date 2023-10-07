package view.commands;

import view.View;

public class ChangeCommands implements Command {
    private View view;

    public ChangeCommands(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Переписать список команд";
    }

    @Override
    public void execute() {
        view.changeCommands();
    }

    @Override
    public void executeChange(String name) {
    }
}
