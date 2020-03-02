package model;

public class Entity {

    private String finalDestination;
    private int trainNumber;
    private Time departureTime;
    private int[] sitsNumber;

    Entity() {
        sitsNumber = new int[4];
    }

    public int[] getSitsNumber() {
        return sitsNumber;
    }
}
