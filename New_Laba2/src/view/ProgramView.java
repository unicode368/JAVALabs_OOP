package view;

import controller.Converter;

public interface ProgramView {
    void print(String message);
    void printError(String message);
/*
    public final String BOOK_LIST = "Поточний список книг:";

    public final String BOOK_NUMBER = "Введіть номер книги, яку бажаєте видалити:";
    public final String BOOK_EDIT = "Введіть номер книги, інформацію про яку бажаєте редагувати:";
    public final String LIBRARIAN_LOGIN = "Введіть логін бібліотекаря:";
    public final String LIBRARIAN_PASSWORD = "Введіть пароль бібліотекаря:";
    public final String LIBRARIAN_DATA = "Введіть дату видання книги:";


    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printError(String message) {
        System.err.println(message);
    }

    public void result(String message, Converter converter) {
        System.out.println(message);
        System.out.println(converter.toString());
    }*/
}
