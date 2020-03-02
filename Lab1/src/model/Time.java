package model;

public class Time {

    private int hours;
    private int minutes;

    Time(String time) {
        hours = Integer.parseInt(time.split(":")[0]);
        minutes = Integer.parseInt(time.split(":")[1]);
    }

    public String toString() {
        return hours + ":" + minutes;
    }
}
