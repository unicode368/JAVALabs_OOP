package Controller;

public class Validator {
    boolean checkOption(String option) {
        if (!option.equals("1") & !option.equals("2")) {
            return false;
        }
        return true;
    }
}
