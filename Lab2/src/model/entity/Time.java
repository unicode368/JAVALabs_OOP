package model.entity;

public class Time {

    private int hours;
    private int minutes;

    public Time() {
        hours = 0;
        minutes = 0;
    }

    public Time(String time) {
        hours = Integer.parseInt(time.split(":")[0]);
        minutes = Integer.parseInt(time.split(":")[1]);
    }

    public static boolean compare(Time time1, Time time2) {
        if (time1.hours < time2.hours) {
            return true;
        } else {
            return time1.hours == time2.hours && time1.minutes <= time2.minutes;
        }
    }

    public String toString() {
        if (hours < 10 && minutes < 10) {
            return "0" + hours + ":" + "0" + minutes;
        } else if (hours < 10) {
            return "0" + hours + ":" + minutes;
        } else if (minutes < 10) {
            return hours + ":"+ "0" + minutes;
        }
        return hours + ":" + minutes;
    }
}
