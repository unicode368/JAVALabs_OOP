package view;

public class LibrarianView implements ProgramView {

    public final String LIBRARIAN_WELCOME = "Ласкаво просимо, librarian!" + "\n" +
            "Будь ласка, оберіть опцію:" + "\n" +
            "1. Особистий кабінет."  + "\n" +
            "0. Вийти.";

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public void printError(String message) {

    }
}
