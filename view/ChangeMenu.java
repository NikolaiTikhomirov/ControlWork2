package view;

import view.commands.AddCommands;
import view.commands.ChangeBirth;
import view.commands.ChangeCommands;
import view.commands.ChangeName;
import view.commands.Command;
import view.commands.Finish;
import view.commands.SaveChanges;

import java.util.ArrayList;
import java.util.List;

public class ChangeMenu implements Menu{
    private List<Command> commandList;
    private View view;

    public ChangeMenu(View view) {
        this.view = view;
        commandList = new ArrayList<>();
        commandList.add(new ChangeName(view));
        commandList.add(new ChangeBirth(view));
        commandList.add(new ChangeCommands(view));
        commandList.add(new AddCommands(view));
        // commandList.add(new SaveChanges(view));
        // commandList.add(new Finish(view));
    }

    public String print(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        return stringBuilder.toString();
    }

    public void executeChange(int numCommand, String name){
        (commandList.get(numCommand - 1)).executeChange(name);
    }

    public int size(){
        return commandList.size();
    }

    @Override
    public void execute(int numCommand) {
    }
}
