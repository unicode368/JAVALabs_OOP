package view;

import controller.Converter;

public class ProgramView {

    public final String TIME = "Введіть час:";
    public final String FINAL_DESTINATION = "Введіть пункт призначення:";
    public final String TRAINS_WITH_GENERAL_PLACES = "Поїзди, які мають загальні місця:";
    public final String SEARCHED_BY_PLACE_AND_TIME = "Поїзди, які слідують до заданого пункту " +
            "призначення та відправляються після заданого часу";
    public final String TRAIN_LIST = "Список поїздів:";
    public final String FILE_LOCATION = "Введіть шлях до файлу:";
    public final String SAVE_TO_FILE_OFFER = "Бажаєте зберегти результат в файл?(так/ні)";
    public final String FILE_NAME = "Вкажіть ім'я файлу:";
    public final String NEW_FILE_LOCATION = "Вкажіть шлях, де бажаєте зберегти файл:";
    public final String RESULT = "Файл записано.";
    public final String FILE_NOT_WRITTEN = "Не вдалось записати файл.";
    public final String FILE_NOT_READ = "Не вдалось прочитати файл.";

    public ProgramView() {

    }

    public void show() {
        System.out.println("Оберіть дію:" + "\n1. Отримати список поїздів, які мають загальні місця" +
                "\n2. Отримати список поїздів, які слідують до заданого пункту призначення та відправляються" +
                " після заданого часу" + "\n0. Завершити роботу");
    }

    public void printError(String message) {
        System.err.println(message);
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void result(String message, Converter converter) {
        System.out.println(message);
        System.out.println(converter.toString());
    }

}
