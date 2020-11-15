package view;

import controller.Converter;

public class AdminView implements ProgramView{

    public final String ADMIN_WELCOME = "Ласкаво просимо, admin!" + "\n" +
            "Будь ласка, оберіть опцію:" + "\n" +
            "1. Додати книгу."  + "\n" +
            "2. Видалити книгу." + "\n" +
            "3. Редагувати інформацію про книгу." + "\n" +
            "4. Створити бібліотекаря." + "\n" +
            "5. Видалити бібліотекаря." + "\n" +
            "6. Заблокувати/розблокувати користувача." + "\n" +
            "0. Вийти.";
    public final String BOOK_NAME = "Введіть назву книги:";
    public final String BOOK_AUTHOR = "Введіть автора книги:";
    public final String BOOK_EDITION = "Введіть видавництво книги:";
    public final String BOOK_DATA = "Введіть дату видання книги:";
    public final String LOGIN = "Введіть логін:";
    public final String PASSWORD = "Введіть пароль:";
    public final String USER_EDIT = "Введіть номер користувача, статус якого бажаєте змінити:";
    public final String USER_LIST = "Поточний список користувачів:";

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public void printError(String message) {
        System.err.println(message);
    }

    public void show(Converter info) {
        System.out.println(info.toString());
        System.out.println();
    }

}
