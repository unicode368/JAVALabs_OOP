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
       Entity[] result = new Entity[defineResultSize(resultSize, 1, new Time(), "")];
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
        Entity[] result = new Entity[defineResultSize(resultSize, 2, time, finalDestination)];
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


    public int defineResultSize(int resultSize, int option, Time time, String finalDestination) {
        if (option == 1) {
            for (Entity aList : list) {
                if (aList.getSitsNumber()[0] > 0) {
                    resultSize++;
                }
            }
        } else {
            for (Entity aList : list) {
                if (aList.getFinalDestination().equals(finalDestination) &&
                        Time.compare(time, aList.getDepartureTime())) {
                    resultSize++;
                }
            }
        }
        return resultSize;
    }

    public Entity[] getResults(Entity[] result, int option, Time time, String finalDestination) {
        int j;
        if (option == 1) {
            j = 0;
            for (Entity aList : list) {
                if (aList.getSitsNumber()[0] > 0) {
                    result[j] = aList;
                    j++;
                }
            }
        } else {
            j = 0;
            for (Entity aList : list) {
                if (aList.getFinalDestination().equals(finalDestination) &&
                        Time.compare(time, aList.getDepartureTime())) {
                    result[j] = aList;
                    j++;
                }
            }
        }
        return result;
    }

    public Entity[] getList() {
        return list;
    }
}
