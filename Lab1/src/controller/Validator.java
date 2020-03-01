package controller;

import java.util.regex.Pattern;

public class Validator {

    private Pattern pattern;

    Validator() {
        pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
    }

    public boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }

    boolean checkOption(String option) {
        if (!isNumeric(option)) {
            return false;
        } else if (!option.equals("1") & !option.equals("2")) {
            return false;
        }
        return true;
    }

    boolean checkArraySize(String size) {
        if () {

        } else if () {

        } else if () {

        }
        return true;
    }
}
