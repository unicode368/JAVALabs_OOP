package view;

import controller.Converter;

public class ProgramView {
    public final String WELCOME = "Ласкаво просимо!" + "\n" +
            "Будь ласка, оберіть опцію:" + "\n" +
            "1. Зареєструватись."  + "\n" +
            "2. Увійти як адміністратор." + "\n" +
            "3. Увійти як бібліотекар." + "\n" +
            "4. Увійти як користувач." + "\n" +
            "5. Шукати книгу." + "\n" +
            "0. Завершити роботу.";
    public final String LOGIN = "Введіть логін:";
    public final String PASSWORD = "Введіть пароль:";
    public final String ADMIN_WELCOME = "Ласкаво просимо, admin!" + "\n" +
            "Будь ласка, оберіть опцію:" + "\n" +
            "1. Додати книгу."  + "\n" +
            "2. Видалити книгу." + "\n" +
            "3. Редагувати інформацію про книгу." + "\n" +
            "4. Створити бібліотекаря." + "\n" +
            "5. Видалити бібліотекаря." + "\n" +
            "6. Заблокувати користувача." + "\n" +
            "7. Розблокувати користувача." + "\n" +
            "0. Вийти.";
    public final String READER_WELCOME = "Ласкаво просимо, reader!" + "\n" +
            "Будь ласка, оберіть опцію:" + "\n" +
            "1. Особистий кабінет."  + "\n" +
            "2. Замовити книгу." + "\n" +
            "0. Вийти.";
    public final String LIBRARIAN_WELCOME = "Ласкаво просимо, librarian!" + "\n" +
            "Будь ласка, оберіть опцію:" + "\n" +
            "1. Особистий кабінет."  + "\n" +
            "0. Вийти.";
    public final String BOOK_NAME = "Введіть назву книги:";
    public final String BOOK_AUTHOR = "Введіть автора книги:";
    public final String BOOK_EDITION = "Введіть видавництво книги:";
    public final String BOOK_DATA = "Введіть дату видання книги:";
    public final String BOOK_LIST = "Поточний список книг:";
    public final String USER_LIST = "Поточний список користувачів:";
    public final String BOOK_NUMBER = "Введіть номер книги, яку бажаєте видалити:";
    public final String BOOK_EDIT = "Введіть номер книги, інформацію про яку бажаєте редагувати:";
    public final String USER_EDIT = "Введіть номер користувача, статус якого бажаєте змінити:";
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
    }
}
