package view;

import controller.Converter;

public class GeneralView implements ProgramView {
    public final String WELCOME = "Ласкаво просимо!" + "\n" +
            "Будь ласка, оберіть опцію:" + "\n" +
            "1. Зареєструватись."  + "\n" +
            "2. Увійти." + "\n" +
            "3. Переглянути каталог." + "\n" +
            "4. Шукати книгу." + "\n" +
            "0. Завершити роботу.";
    public final String LOGIN = "Введіть логін:";
    public final String PASSWORD = "Введіть пароль:";

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    public void show(Converter info) {
        System.out.println(info.toString());
        System.out.println();
    }

    @Override
    public void printError(String message) {
        System.err.println(message);
    }
}
