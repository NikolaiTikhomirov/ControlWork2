package view;

import view.commands.AddAnimal;
import view.commands.ChangeAnimal;
import view.commands.Command;
import view.commands.Finish;
import view.commands.GetAnimalList;
import view.commands.GetCounter;
import view.commands.SaveChanges;

import java.util.ArrayList;
import java.util.List;

public class MainMenu implements Menu{
    private List<Command> commandList;
    private View view;

    public MainMenu(View view) {
        this.view = view;
        commandList = new ArrayList<>();
        commandList.add(new AddAnimal(view));
        commandList.add(new GetAnimalList(view));
        commandList.add(new GetCounter(view));
        commandList.add(new ChangeAnimal(view));
        commandList.add(new SaveChanges(view));
        commandList.add(new Finish(view));
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

    public void execute(int numCommand){
        commandList.get(numCommand - 1).execute();
    }

    public int size(){
        return commandList.size();
    }

    @Override
    public void executeChange(int numCommand, String name) {
    }
}
