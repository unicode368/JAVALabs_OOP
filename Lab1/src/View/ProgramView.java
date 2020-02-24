package View;

import Controller.InputStream;
import Controller.OutputStream;

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
        System.out.println("");
    }

    public void result() {

    }

}
