package view;

import controller.Converter;

public class ProgramView {

    public final String WRONG_OPTION = "Невірно введені дані. Будь ласка, оберіть одну з опцій 1 або 2.";
    public final String ARRAY_SIZE = "Введіть кількість поїздів:";
    public final String INVALID_ARRAY_SIZE = "Розмір масиву повинен бути додатнім цілим числом.";
    public final String INVALID_TIME = "Невірно введений час. Будь ласка, спробуйте  ще раз.";
    public final String TIME = "Введіть час:";
    public final String FINAL_DESTINATION = "Введіть пункт призначення:";
    public final String INVALID_ACTION = "WARNING!!!INVALID ACTION HAS BEEN DETECTED";
    public final String INVALID_DESTINATION = "Невірно введений пункт призначення. Будь ласка, " +
            "спробуйте  ще раз.";
    public final String TRAINS_WITH_GENERAL_PLACES = "Поїзди, які мають загальні місця:";
    public final String SEARCHED_BY_PLACE_AND_TIME = "Поїзди, які слідують до заданого пункту " +
            "призначення та відправляються після заданого часу";
    public final String TRAIN_LIST = "Список поїздів:";

    public ProgramView() {

    }

    public void show() {
        System.out.println("Оберіть дію:" + "\n1. Отримати список поїздів, які мають загальні місця" +
                "\n2. Отримати список поїздів, які слідують до заданого пункту призначення та відправляються" +
                " після заданого часу" + "\n0. Завершити роботу");
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printError(String message) {
        System.err.println(message);
    }

    public void result(String message, Converter converter) {
        System.out.println(message);
        System.out.println();
        System.out.println(converter.toString());
        System.out.println();
    }

}
