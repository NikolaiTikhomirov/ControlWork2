package view.commands;

import view.View;

public class GetAnimalList implements Command {
    private View view;

    public GetAnimalList(View view) {
        this.view = view;
    }

    @Override
    public String getDescription() {
        return "Посмотреть список животных";
    }

    @Override
    public void execute() {
        view.getAnimalList();
    }

    @Override
    public void executeChange(String name) {
    }
}
