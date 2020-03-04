package model;

public class Time {

    private int hours;
    private int minutes;

    Time(String time) {
        hours = Integer.parseInt(time.split(":")[0]);
        minutes = Integer.parseInt(time.split(":")[1]);
    }

    public boolean compare(Time time1, Time time2) {
        if (time1.hours < time2.hours) {
            return true;
        } else {
            return time1.hours == time2.hours && time1.minutes <= time2.minutes;
        }
    }

    public String toString() {
        return hours + ":" + minutes;
    }
}
