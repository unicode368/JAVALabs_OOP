package controller;

import java.util.regex.Pattern;

public class Validator {

    Validator() {

    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return Pattern.compile("-?\\d+(\\.\\d+)?").matcher(strNum).matches();
    }

    static boolean isTimeFormat(String time) {
        if (!time.contains(":")) {
            return false;
        } else if (time.split(":").length != 2) {
            return false;
        }
        String hours = time.split(":")[0];
        String minutes = time.split(":")[1];
        if ((!isNumeric(hours) && !isNumeric(minutes)) || !isNumeric(hours)
                || !isNumeric(hours)) {
            return false;
        } else if (Integer.parseInt(hours) >= 24 || Integer.parseInt(hours) < 0) {
            return false;
        } else {
            return (Integer.parseInt(minutes) <= 59 && Integer.parseInt(minutes) >= 0);
        }
    }

    static boolean isCity(String city) {
        if (isNumeric(city)) {
            return false;
        }
        return true;
    }

    static boolean checkOption(String option) {
        return isNumeric(option) && (option.equals("1") || option.equals("2") ||
                option.equals("0"));
    }

    static boolean checkArraySize(String size) {
        return isNumeric(size);
    }
}
