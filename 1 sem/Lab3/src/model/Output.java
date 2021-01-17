package model;

import model.entity.Entity;

import java.io.*;

public class Output {


    public void writeToFile(String location, Entity[] result) throws IOException {
        File file = new File(location);
        try(ObjectOutputStream object_output =
                    new ObjectOutputStream(new FileOutputStream(file));
            BufferedWriter string_output = new BufferedWriter(new FileWriter(file))) {
            if (location.contains(".dat")) {
                for(Entity object: result){
                    object_output.writeObject(object);
                }
                object_output.close();
            } else {
                for(Entity object: result){
                    string_output.write(object.getTrainNumber() +
                            "," + object.getFinalDestination() +
                            "," + object.getDepartureTime() +
                            "," + object.getSitsNumber()[0] +
                            "," + object.getSitsNumber()[1] +
                            "," + object.getSitsNumber()[2] +
                            "," + object.getSitsNumber()[3]);
                }
                string_output.close();
            }
        }
    }
}
