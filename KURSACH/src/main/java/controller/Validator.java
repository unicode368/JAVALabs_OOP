package controller;

import model.exceptions.*;

import java.util.regex.Pattern;

public class Validator {

    public Validator() {

    }

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

    static void isPositive(int number) throws NegativeNumberOfSitsException {
        if (number < 0) {
            throw new NegativeNumberOfSitsException("");
        }
    }

    static void isCity(String city) throws InvalidFinalDestinationException {
        if (hasDigitsOrSpecialCharacters(city)) {
            throw new InvalidFinalDestinationException("Невірно введено пункт призначення. " +
                    "Будь ласка, спробуйте ще");
        }
    }

    static void checkOption(String option) throws InvalidOptionException {
        if (!(isNumeric(option) && (option.equals("1") || option.equals("2") ||
                option.equals("0")))) {
            throw new InvalidOptionException("Опція має бути одним із запропонованих чисел."
            + "Буль ласка, спробуйте ще");
        }
    }

    static void checkYesOrNoOptions(String option) throws InvalidOptionException {
        if (!option.equals("так") & !option.equals("ні")) {
            throw new InvalidOptionException("Будь ласка, оберіть так або ні.");
        }
    }

    static void checkFormat(String filename) {
        if (!(filename.substring(filename.length() - 4).equals(".csv") ||
                filename.substring(filename.length() - 4).equals(".dat"))) {
            throw new InvalidFileTypeException("Вказаний файл мусить мати формат .csv або .dat");
        }
    }

}
