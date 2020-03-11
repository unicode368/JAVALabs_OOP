package model.entity;

public class Entity {

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

    public void setFinalDestination(String finalDestination) {
        this.finalDestination = finalDestination;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public void setDepartureTime(Time departureTime) {
        this.departureTime = departureTime;
    }

    public void setSitsNumber(int[] sitsNumber) {
        this.sitsNumber = sitsNumber;
    }
}
