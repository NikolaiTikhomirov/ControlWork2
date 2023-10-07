package view.commands;

public interface Command {
    String getDescription();
    void execute();
    void executeChange(String name);
}
