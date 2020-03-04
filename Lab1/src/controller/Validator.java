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
        return isNumeric(option) & (option.equals("1") | option.equals("2"));
    }

    boolean checkArraySize(String size) {
        Controller error = new Controller();
        if (!isNumeric(size)) {
            error.invalidArraySize();
            return false;
        }
        return true;
    }
}
