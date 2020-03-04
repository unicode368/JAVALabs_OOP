package model;

import controller.Controller;

public class BusinessLogic {

    private static Entity[] list;
    private static Entity[] result;

    public void execute(int option) {
        Controller request = new Controller();
        request.askForData(option);
        if (option == 1) {
            result = generalPlaces();
        } else {
            result = searchByPlaceAndTime();
        }
        request.sendResult(result, option);
    }

    private Entity[] generalPlaces() {
       int resultSize = 0;
       result = new Entity[defineResultSize(resultSize, 1)];
       addResults(1);
       return result;
    }

    private Entity[] searchByPlaceAndTime() {
        int resultSize = 0;
        result = new Entity[defineResultSize(resultSize, 2)];
        addResults(2);
        return result;
    }

    public void setList(Entity[] list) {
        BusinessLogic.list = list;
    }

    public int defineResultSize(int resultSize, int option) {
        if (option == 1) {
            for (Entity aList : list) {
                if (aList.getSitsNumber()[0] > 0) {
                    resultSize++;
                }
            }
        } else {
            for (Entity aList : list) {
                if (aList.getSitsNumber()[0] > 0) {
                    resultSize++;
                }
            }
        }
        return resultSize;
    }

    public void addResults(int option) {
        int j = 0;
        if (option == 1) {
            for (Entity aList : list) {
                if (aList.getSitsNumber()[0] > 0) {
                    result[j] = aList;
                    j++;
                }
            }
        } else {

        }

    }
}
