package model;

import model.entity.Entity;
import model.entity.Time;

public class BusinessLogic {

    private Entity[] list;

<<<<<<< Updated upstream
    public BusinessLogic(int size) {
        list = new DataSource().generateArray(size);
=======
<<<<<<<< Updated upstream:Lab2/src/model/BusinessLogic.java
    public BusinessLogic() {
        list = new DataSource().generateArray();
========
    public BusinessLogic(int size) {
        list = new DataSource().generateArray(size);
>>>>>>>> Stashed changes:Lab1/src/model/BusinessLogic.java
>>>>>>> Stashed changes
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
