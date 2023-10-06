package view.commands;

import view.View;

public class ChangeCommands implements Command {
    private View view;

    public ChangeCommands(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Переписать спикой команд";
    }

    @Override
    public void execute() {
        view.changeCommands();
    }
}
