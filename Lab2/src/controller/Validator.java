package controller;

<<<<<<< Updated upstream
<<<<<<< Updated upstream
import java.util.regex.Pattern;

public class Validator {
=======
=======
import java.util.regex.Pattern;
>>>>>>> Stashed changes
<<<<<<<< Updated upstream:Lab2/src/controller/Validator.java
import model.exceptions.InvalidFinalDestinationException;
import model.exceptions.InvalidOptionException;
import model.exceptions.InvalidTimeException;

<<<<<<< Updated upstream
========
>>>>>>>> Stashed changes:Lab1/src/controller/Validator.java
import java.util.regex.Pattern;

class Validator {
>>>>>>> Stashed changes
=======
class Validator {
========

public class Validator {
>>>>>>>> Stashed changes:Lab1/src/controller/Validator.java
>>>>>>> Stashed changes

    Validator() {

    }

<<<<<<< Updated upstream
<<<<<<< Updated upstream
    public static boolean isNumeric(String strNum) {
=======
    private static boolean isNumeric(String strNum) {
>>>>>>> Stashed changes
=======
    private static boolean isNumeric(String strNum) {
>>>>>>> Stashed changes
        if (strNum == null) {
            return false;
        }
        return Pattern.compile("-?\\d+(\\.\\d+)?").matcher(strNum).matches();
    }

<<<<<<< Updated upstream
<<<<<<< Updated upstream
=======
=======
>>>>>>> Stashed changes
<<<<<<<< Updated upstream:Lab2/src/controller/Validator.java
    private static boolean hasDigitsOrSpecialCharacters(String str) {
        if (str == null) {
            return true;
        }
        String specialCharacters=" !#$%&()*+,-./:;<=>?@[]^_`{|}";
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

    static void isCity(String city) throws InvalidFinalDestinationException {
        if (hasDigitsOrSpecialCharacters(city)) {
            throw new InvalidFinalDestinationException("Невірно введено пункт призначення. " +
                    "Будь ласка, спробуйте ще");
========
<<<<<<< Updated upstream
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
<<<<<<< Updated upstream
=======
>>>>>>>> Stashed changes:Lab1/src/controller/Validator.java
>>>>>>> Stashed changes
=======
>>>>>>>> Stashed changes:Lab1/src/controller/Validator.java
>>>>>>> Stashed changes
        }
        return true;
    }

<<<<<<< Updated upstream
<<<<<<< Updated upstream
    static boolean checkOption(String option) {
        return isNumeric(option) && (option.equals("1") || option.equals("2") ||
                option.equals("0"));
=======
=======
>>>>>>> Stashed changes
    static void checkOption(String option) throws InvalidOptionException {
        if (!(isNumeric(option) && (option.equals("1") || option.equals("2") ||
                option.equals("0")))) {
            throw new InvalidOptionException("Опція має бути одним із запропонованих чисел."
            + "Буль ласка, спробуйте ще");
        }
<<<<<<< Updated upstream
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
    }

    static boolean checkArraySize(String size) {
        return isNumeric(size);
    }
}
