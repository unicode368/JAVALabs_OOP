package model;

public class Date {

    private int day;
    private int month;
    private int year;

    public Date(String date) {
        String[] numbers = date.split("\\.");
        day = Integer.parseInt(numbers[0]);
        month = Integer.parseInt(numbers[1]);
        year = Integer.parseInt(numbers[2]);
    }

    public String toString() {
        return day + "." + month + "." + year;
    }

    public boolean equal(Date d1, Date d2) {
        if (d1.day == d2.day &&
                d1.month == d2.month && d1.year == d2.year) {
            return true;
        }
        return false;
    }
}
