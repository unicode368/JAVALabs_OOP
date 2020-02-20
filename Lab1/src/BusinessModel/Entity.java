package BusinessModel;

public class Entity {

    private String finalDestination;
    private int trainNumber;
    private Time departureTime;
    private int[] placeNumber;

    Entity() {
        placeNumber = new int[4];
    }
}
