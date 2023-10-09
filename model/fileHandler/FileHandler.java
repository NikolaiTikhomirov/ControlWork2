package model.fileHandler;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import model.AnimalList;
import model.Counter;

public class FileHandler implements Writable{

    @Override
    public void save(Serializable serializable, String filePath) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))){
            objectOutputStream.writeObject(serializable);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Сохранить не удалось");
        }
    }

    @Override
    public Object read(String filePath) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath))){
            return objectInputStream.readObject();
        } catch (Exception e) {
            Serializable file;
            if (filePath.contains("counter")){
                file = new Counter();
                System.out.println("Создан новый счетчик");
            }
            else{
                file = new AnimalList<>();
                System.out.println("Создан новый список животных");
            }
            FileHandler writable = new FileHandler();
            writable.save(file, filePath);
            return file;
        }
    }
}
