package model;

import model.entity.Entity;
import model.entity.Time;

public class BusinessLogic {

    private Entity[] list;

    public BusinessLogic(int size) {
        list = new DataSource().generateArray(size);
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
