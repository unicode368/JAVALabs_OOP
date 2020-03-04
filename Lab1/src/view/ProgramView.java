package view;

import controller.OutputStream;

public class ProgramView {

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

    public void invalidArraySize() {
        System.out.println("Розмір масиву повинен бути додатнім цілим числом.");
    }

    public void result(int option, OutputStream output) {
        if (option == 1) {
            System.out.println("Поїзди, які мають загальні місця:");
        } else {
            System.out.println("Поїзди, які слідують до заданого пункту призначення та відправляються після " +
                    "заданого часу");
        }
        System.out.println(output.toString());
    }

}