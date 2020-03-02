package controller;

import java.util.regex.Pattern;

public class Validator {

    private Pattern pattern;
    private Controller error;

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
        if (!isNumeric(size)) {
            error.invalidArraySize("not numeric");
            return false;
        }
        float numeric = Float.parseFloat(size);
        if (numeric <= 0) {
            error.invalidArraySize("negative number");
            return false;
        } else if (numeric % 1 != 0) {
            error.invalidArraySize("not integer");
            return false;
        }
        return true;
    }
}
