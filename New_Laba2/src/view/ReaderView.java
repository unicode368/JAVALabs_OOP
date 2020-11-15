package view;

public class ReaderView implements ProgramView {

    public final String READER_WELCOME = "Ласкаво просимо, reader!" + "\n" +
            "Будь ласка, оберіть опцію:" + "\n" +
            "1. Особистий кабінет."  + "\n" +
            "2. Замовити книгу." + "\n" +
            "0. Вийти.";

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public void printError(String message) {

    }
}
