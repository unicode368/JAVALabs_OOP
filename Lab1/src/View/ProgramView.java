package View;

import controller.OutputStream;

public class ProgramView {

    private OutputStream result;

    public ProgramView() {

    }

    public void show() {
        System.out.println("Оберіть дію:" + "\n1. Отримати список поїздів, які мають загальні місця" +
                "\n2. Отримати список поїздів, які слідують до заданого пункту призначення та відправляються" +
                " після заданого часу");
    }

    public void wrongOption() {
        System.out.println("Невірно введені дані. Будь ласка, оберіть одну з опцій 1 або 2.");
    }

    public void arraySize() {
        System.out.println("Введіть кількість поїздів:");
    }

    public void notNumeric() {
        System.out.println("Розмір списку повинен бути числом.");
    }

    public void negativeNumber() {
        System.out.println("Розмір списку повинен бути числом.");
    }

    public void notInteger() {
        System.out.println("Введіть ціле невід'ємне число!");
    }


    public void result(int option) {
        if (option == 1) {
            System.out.println("Поїзди, які мають загальні місця:");
        } else {
            System.out.println("Поїзди, які слідують до заданого пункту призначення та відправляються після " +
                    "заданого часу");
        }
        System.out.println(result.toString());
    }

}
