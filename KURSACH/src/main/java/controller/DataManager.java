package controller;

import model.Input;
import model.Output;
import model.entity.Entity;

import java.io.IOException;

public class DataManager {

    private Input input;
    private Output output;
    private final String FILEPATH = "C:\\Users\\Olya\\Documents\\GitHub\\" +
            "JAVALabs_OOP\\KURSACH\\src\\main\\java\\Book1.csv";

    public DataManager() {
        input = new Input();
        output = new Output();
    }

   public Entity[] loadDataFromFile() throws IOException {
       return input.getFile(FILEPATH);
   }

   public void writeDataToFile(String location, Entity[] result) throws IOException {
        output.writeToFile(location, result);
   }

}

/*
       BufferedReader br = new BufferedReader(
               new InputStreamReader(
                       new FileInputStream(filename), StandardCharsets.UTF_8));
       int lineCounter = 0;
       String line;
       while (br.readLine() != null) {
           lineCounter++;
       }
       br = new BufferedReader(
               new InputStreamReader(
                       new FileInputStream(filename), StandardCharsets.UTF_8));
       Entity[] trains = new Entity[lineCounter];
       lineCounter = 0;
       while ((line = br.readLine()) != null) {
           trains[lineCounter] = new Entity(line.split(","));
           lineCounter++;
       }
       return trains;*/