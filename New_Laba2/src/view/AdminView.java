package view;


public class AdminView extends ProgramView{

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
    public final String USER_EDIT = "Введіть номер користувача, статус якого бажаєте змінити:";
    public final String USER_LIST = "Поточний список користувачів:";
    public final String BOOK_LIST = "Поточний список книг:";
    public final String BOOK_NUMBER = "Введіть номер книги, яку бажаєте видалити:";
    public final String LIBRARIAN_DELETE = "Введіть номер бібліотекаря, " +
            "якого бажаєте видалити:";
}
