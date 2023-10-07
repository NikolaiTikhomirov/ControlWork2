package view;

public interface Menu {

    public String print();
    public void execute(int numCommand);
    public int size();
    public void executeChange(int numCommand, String name);
}
