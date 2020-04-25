package controller;

import model.exceptions.InvalidFinalDestinationException;
import model.exceptions.InvalidTimeException;

import java.util.regex.Pattern;

public class Validator {

    Validator() {

    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return Pattern.compile("\\d").matcher(strNum).matches();
    }

    public static boolean hasDigitsOrSpecialCharacters(String str) {
        if (str == null) {
            return false;
        }
        return Pattern.compile(".*http://.*", Pattern.CASE_INSENSITIVE).matcher(str).matches();
    }

    static void isTimeFormat(String time) throws InvalidTimeException {
        if (!Pattern.matches("^\\d{1,2}(:\\d{2})?$",time)) {
           throw new InvalidTimeException("Невірний формат часу: hh:mm. Будь ласка, спробуйте" +
                   "ще");
        }
        int hours = Integer.parseInt(time.split(":")[0]);
        int minutes = Integer.parseInt(time.split(":")[1]);
        if (hours >= 24 || hours < 0) {
            throw new InvalidTimeException("Години мають бути додатнім числом яке не більше 23");
        } else if (minutes > 59 || minutes < 0){
            throw new InvalidTimeException("Хвилини мають бути додатнім числом яке не більше 59");
        }
    }

    static void isCity(String city) throws InvalidFinalDestinationException {
        if (hasDigitsOrSpecialCharacters(city)) {
            throw new InvalidTimeException("");
        }
    }

    static boolean checkOption(String option) {
        return isNumeric(option) && (option.equals("1") || option.equals("2") ||
                option.equals("0"));
    }

}
