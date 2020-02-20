package View;

import Controller.InputStream;
import Controller.OutputStream;

public class ProgramView {

    private InputStream data;
    private OutputStream result;

    public ProgramView() {

    }

    public void show() {
        System.out.println("Оберіть дію:" + "\n1. Отримати список поїздів, які мають загальні місця" +
                "\n2. Отримати список поїздів, які слідують до заданого пункту призначення та відправляються" +
                " після заданого часу");
    }

    public void result() {

    }

}
