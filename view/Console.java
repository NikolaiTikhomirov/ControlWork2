package view;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import model.Animals.Animal;
import presenter.Presenter;
import view.exceptions.UserInterDateException;
import view.exceptions.UserInterNameException;
import view.exceptions.UserInterClassException;
import view.exceptions.UserInterCommandException;

public class Console implements View{

    private static final String INPUT_ERROR = "Введенные данные некорректны, попробуйте еще раз";
    private Presenter presenter;
    private Scanner scanner;
    private Boolean work;
    private MainMenu mainMenu;
    private ChangeMenu changeMenu;

    
    public Console(){
        scanner = new Scanner(System.in);
        work = true;
        mainMenu = new MainMenu(this);
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }
    
    @Override
    public void start() {
        System.out.println("Доброго времени суток");;
        while (work) {
            printMenu();
            execute();
        }
    }
    
    @Override
    public void finish() {
        System.out.println("До скорых встреч");
        scanner.close();
        work = false;
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    private void printAnimalsKindList(){
        System.out.println("1. Собака");
        System.out.println("2. Кошка");
        System.out.println("3. Хомяк");
        System.out.println("4. Лошадь");
        System.out.println("5. Верблюд");
        System.out.println("6. Осел");
    }

    @Override
    public void addAnimal(){
        boolean addWork;
        addWork = true;
        root: while (addWork){
            try {
                Integer animalClass = null;
                System.out.println("Выберите, какого питомца вы хотите добавить");
                printAnimalsKindList();
                try {
                    animalClass = Integer.parseInt(scanner.nextLine());
                } catch (Exception e){}
                if (animalClass == null) throw new UserInterClassException("Воспользуйтесь цифрами");
                if (animalClass < 1 || animalClass > 6) throw new UserInterClassException("Воспользуйтесь цифрами от 1 до 6");


                System.out.println("Введите имя питомца");
                String name = scanner.nextLine();
                if (name.length() < 2)
                    throw new UserInterNameException("Некорректное имя питомца.", name);
                

                System.out.println("Введите дату рождения питомца в формате гггг-мм-дд");
                LocalDate date = null;
                try {
                    date = LocalDate.parse(scanner.nextLine());
                } catch (Exception e){}
                if (date == null) throw new UserInterDateException("Неверный формат даты.");


                System.out.println("Введите команды питомца через пробел");
                String commandsTemp = scanner.nextLine();
                ArrayList<String> commands = new ArrayList<String>(Arrays.asList(commandsTemp.split(" ")));
                if (commandsTemp == "") throw new UserInterCommandException("Список команд пуст");


                presenter.addAnimal(animalClass, name, date, commands);
            }

            catch (UserInterClassException e){
                System.out.println("Некоррекно выбран тип животного\n");
                continue root;
            }
            
            catch (UserInterNameException e){
                System.out.println("Некорректное имя - " + e.getData() + "\n");
                continue root;
            }
            catch(UserInterDateException e){
                System.out.println("Неверный формат даты\n");
                continue root;
            }
            catch(UserInterCommandException e){
                System.out.println("Список команд пуст\n");
                continue root;
            }
            catch (Exception e) {
                e.printStackTrace();
                System.out.println(INPUT_ERROR);
                continue root;
            }
            addWork = false;
        }
    }
    
    @Override
    public void getAnimalList() {
        presenter.getAnimalList();
    }

    private void printMenu(){
        System.out.println(mainMenu.print());
    }

    private void execute(){
        String line = scanner.nextLine();
        if (checkTextForInt(line)){
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand)){
                mainMenu.execute(numCommand);
            }
        }
    }

    private boolean checkCommand(int numCommand){
        if (numCommand <= mainMenu.size()){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private boolean checkTextForInt(String text){
        if (text.matches("[0-9]+")){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private void inputError(){
        System.out.println(INPUT_ERROR);
    }

    @Override
    public void saveChanges() {
        presenter.saveChanges();
    }

    @Override
    public void ChangeAnimal() {
        Boolean work = true;
        root: while (work) {
            try {
                getAnimalList();
                System.out.println("Введите имя питомца, чьи данные вы хотите изменить");
                String name = scanner.nextLine();
                Animal animal = presenter.getAnimal(name);
                if (animal == null) throw new UserInterNameException("Питомец не найден", name);
                System.out.println(animal.toString());
                System.out.println("Какие данные вы хотите изменить?");
                changeMenu = new ChangeMenu(this);

                // presenter.ChangeAnimal();
                work = false;
            } catch (UserInterNameException e) {
                System.out.println("Питомец не найден - " + e.getData() + "\n");
                continue root;
            }
        }
    }

    @Override
    public void ChangeName(String name) {
        Boolean work = true;
        root: while (work) {
            try {
                System.out.println("Введите новое имя питомца");
                String newName = scanner.nextLine();
                if (newName.length() < 2)
                    throw new UserInterNameException("Некорректное имя питомца.", newName);
                presenter.ChangeName(name, newName);
                work = false;
            } catch (UserInterNameException e) {
                System.out.println("Некорректное имя - " + e.getData() + "\n");
                continue root;
            }
        }
    }

    @Override
    public void ChangeBirth() {
        presenter.ChangeBirth();
    }

    @Override
    public void ChangeCommands() {
        presenter.ChangeCommands();
    }

    @Override
    public void AddCommands() {
        presenter.AddCommands();
    }

}
