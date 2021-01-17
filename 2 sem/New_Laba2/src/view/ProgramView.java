package view;

import controller.Converter;

public class ProgramView {
/*
    public final String BOOK_EDIT = "Введіть номер книги, інформацію про яку бажаєте редагувати:";
    public final String LIBRARIAN_LOGIN = "Введіть логін бібліотекаря:";
    public final String LIBRARIAN_PASSWORD = "Введіть пароль бібліотекаря:";
    public final String LIBRARIAN_DATA = "Введіть дату видання книги:";
*/
    public final String LOGIN = "Введіть логін:";
    public final String PASSWORD = "Введіть пароль:";

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printError(String message) {
        System.err.println(message);
    }

    public void show(String message, Converter converter) {
        System.out.println(message);
        System.out.println(converter.toString());
    }
}
