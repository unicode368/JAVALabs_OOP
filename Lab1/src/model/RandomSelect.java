package model;

import java.util.Random;

public class RandomSelect {

    public static String selectCity(String[] cities) {
        return cities[new Random().nextInt(13)];
    }

    public static String selectTrainNumber() {
        int number = new Random().nextInt(998) + 1;
        if (number < 10) {
            return "00" + number;
        } else if (number > 10 && number < 100) {
            return "0" + number;
        }
        return String.valueOf(number);
    }

    public static Time selectTime() {
        int hours = new Random().nextInt(23);
        int minutes = new Random().nextInt(59);
        if (hours < 10 && minutes < 10) {
            return new Time("0" + hours + ":" + "0" + minutes);
        } else if (hours < 10) {
            return new Time("0" + hours + ":" + minutes);
        } else if (minutes < 10) {
            return new Time(hours + ":" + "0" + minutes);
        } else {
            return new Time(hours + ":" + minutes);
        }
    }

    public static int[] selectNumberOfPlaces() {
        int[] places = new int[4];
        for (int i = 0; i < places.length; i++) {
            places[i] = new Random().nextInt(80);
        }
        return places;
    }
}
