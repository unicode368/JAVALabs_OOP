package controller;

import model.exceptions.*;
import view.ResourceManager;

import java.util.regex.Pattern;

public class Validator {

    private static ResourceManager language = ResourceManager.INSTANCE;

    private static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return Pattern.compile("-?\\d+(\\.\\d+)?").matcher(strNum).matches();
    }

    private static boolean hasDigitsOrSpecialCharacters(String str) {
        if (str == null) {
            return true;
        }
        String specialCharacters="!#$%&()*+,-./:;<=>?@[]^_`{|}";
        for (int i = 0; i < str.length(); i++) {
            if (specialCharacters.contains(Character.toString(str.charAt(i))))
                return true;
        }
        return Pattern.compile("[0-9]+", Pattern.CASE_INSENSITIVE).matcher(str).matches();
    }

    static void isTimeFormat(String time) throws InvalidTimeException {
        if (!Pattern.matches("^\\d{1,2}(:\\d{2})?$",time)) {
           throw new InvalidTimeException(language.getString("invalid.time"));
        }
        int hours = Integer.parseInt(time.split(":")[0]);
        int minutes = Integer.parseInt(time.split(":")[1]);
        if (hours >= 24 || hours < 0) {
            throw new InvalidTimeException(language.getString("invalid.hours"));
        } else if (minutes > 59 || minutes < 0){
            throw new InvalidTimeException(language.getString("invalid.minutes"));
        }
    }

    static void isPositive(int number) throws NegativeNumberOfSitsException {
        if (number < 0) {
            throw new NegativeNumberOfSitsException(language.getString
                    (language.getString("invalid.number.value")));
        }
    }

    static void isCity(String city) throws InvalidFinalDestinationException {
        if (hasDigitsOrSpecialCharacters(city)) {
            throw new InvalidFinalDestinationException(language.getString("invalid.final.destination"));
        }
    }

    static void checkOption(String option) throws InvalidOptionException {
        if (!(isNumeric(option) && (option.equals("1") || option.equals("2") ||
                option.equals("0")))) {
            throw new InvalidOptionException(language.getString("invalid.option"));
        }
    }

    static void checkYesOrNoOptions(String option) throws InvalidOptionException {
        if (!option.equals(language.getString("validator.yes")) &
                !option.equals(language.getString("validator.no"))) {
            throw new InvalidOptionException(language.getString("invalid.yes.or.no.choice"));
        }
    }

    static void checkFormat(String filename) {
        if (!(filename.substring(filename.length() - 4).equals(".csv") ||
                filename.substring(filename.length() - 4).equals(".dat"))) {
            throw new InvalidFileTypeException(language.getString("invalid.format"));
        }
    }

    static void checkLanguage(String language) {
        if (!(isNumeric(language) && (language.equals("1") || language.equals("2")))) {
            throw new InvalidOptionException(Validator.language.getString("invalid.option"));
        }
    }

}
