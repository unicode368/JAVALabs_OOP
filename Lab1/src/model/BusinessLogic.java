package model;

import controller.Controller;
import controller.InputStream;
import model.entity.Entity;
import model.entity.Time;

public class BusinessLogic {

    private Entity[] list;
    private Entity[] result;
    private Time time;
    private String finalDestination;
    private InputStream input;

    public BusinessLogic() {
        input = new InputStream();
    }

    public void execute(int option) {
        askForData(option);
        if (option == 1) {
            result = generalPlaces();
        } else {
            result = searchByPlaceAndTime();
        }
        new Controller().sendResult(result, option);
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
        this.list = list;
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
                if (aList.getFinalDestination().equals(finalDestination) &&
                        Time.compare(time, aList.getDepartureTime())) {
                    resultSize++;
                }
            }
        }
        return resultSize;
    }

    public void addResults(int option) {
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
    }

    public void setTime(String time) {
        this.time = new Time(time);
    }

    public void setFinalDestination(String finalDestination) {
        this.finalDestination = finalDestination;
    }

    public void askForData(int option) {
        Controller controller = new Controller();
        controller.askForMessages("array size");
        String size = input.option();
        size = controller.validateArraySize(size);
        setList(new DataSource().generateArray(Integer.parseInt(size)));
        if (option == 2){
            controller.askForMessages("time");
            String time = input.option();
            time = controller.validateTime(time);
            controller.askForMessages("final destination");
            String destination = input.option();
            destination = controller.validateFinalDestination(destination);
            setTime(time);
            setFinalDestination(destination);
        }
    }
}
