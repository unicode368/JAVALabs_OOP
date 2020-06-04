package model;

import controller.DataManager;
import model.entity.Entity;
import model.entity.Time;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class BusinessLogic {

    private Entity[] list;

    public BusinessLogic() throws IOException {
        list = new DataManager().loadDataFromFile();
    }

    public Entity[] getTrainsWithGeneralPlaces() {
       int resultSize = 0;
       for (Entity aList : list) {
           if (aList.getSitsNumber()[0] > 0) {
               resultSize++;
           }
       }
       Entity[] result = new Entity[resultSize];
       int j = 0;
       for (Entity aList : list) {
            if (aList.getSitsNumber()[0] > 0) {
                result[j] = aList;
                j++;
            }
       }
       return result;
    }

    public Entity[] searchByPlaceAndTime(Time time, String finalDestination) {
        int resultSize = 0;
        for (Entity aList : list) {
            if (aList.getFinalDestination().equals(finalDestination) &&
                    Time.compare(time, aList.getDepartureTime())) {
                resultSize++;
            }
        }
        Entity[] result = new Entity[resultSize];
        int j = 0;
        for (Entity aList : list) {
            if (aList.getFinalDestination().equals(finalDestination) &&
                    Time.compare(time, aList.getDepartureTime())) {
                result[j] = aList;
                j++;
            }
        }
        return result;
    }

    public Entity[] getList() {
        return list;
    }
}
