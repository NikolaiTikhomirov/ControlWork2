package view.commands;

import view.View;

public class GetCounter implements Command {
    private View view;

    public GetCounter(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Узнать сколько всего питомцев создавалось";
    }

    @Override
    public void execute() {
        view.getCounter();
    }

    @Override
    public void executeChange(String name) {
    }
}
