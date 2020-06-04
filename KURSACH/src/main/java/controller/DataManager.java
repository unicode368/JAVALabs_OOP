package controller;

import model.Input;
import model.Output;
import model.entity.Entity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class DataManager {

    private Input input;
    private Output output;
    private final String FILEPATH = "C:\\Users\\Olya\\Documents\\GitHub\\" +
            "JAVALabs_OOP\\KURSACH\\src\\main\\java\\Book1.csv";
    private static final Logger logger = LogManager.getLogger("data_manager");

    public DataManager() {
        input = new Input();
        output = new Output();
    }

   public Entity[] loadDataFromFile() throws IOException {
        logger.info("Парсинг файлу...");
       return input.getFile(FILEPATH);
   }

   public void writeDataToFile(String location, Entity[] result) throws IOException {
       logger.info("Запис результату в файл...");
        output.writeToFile(location, result);
   }

}
