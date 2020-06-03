package model.entity;

import model.exceptions.InvalidFinalDestinationException;
import model.exceptions.InvalidTimeException;

import java.io.Serializable;

public class Entity implements Serializable {

    private String finalDestination;
    private String trainNumber;
    private Time departureTime;
    private int[] sitsNumber;

    public Entity() {
        sitsNumber = new int[]{0, 0, 0, 0};
        finalDestination = null;
        trainNumber = "000";
        departureTime = new Time("0:00");
    }

    public Entity(String[] info) throws InvalidTimeException, InvalidFinalDestinationException {
        trainNumber = info[0];
        finalDestination = info[1];
        departureTime = new Time(info[2]);
        sitsNumber = new int[4];
        int j = 0;
        for (int i = 3; i < info.length; i++) {
            sitsNumber[j] = Integer.parseInt(info[i]);
            j++;
        }
    }

    public Entity(String finalDestination, String trainNumber, Time departureTime, int[] sitsNumber) {
        this.finalDestination = finalDestination;
        this.trainNumber = trainNumber;
        this.departureTime = departureTime;
        this.sitsNumber = sitsNumber;
    }

    public int[] getSitsNumber() {
        return sitsNumber;
    }

    public String getFinalDestination() {
        return finalDestination;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public Time getDepartureTime() {
        return departureTime;
    }

}
