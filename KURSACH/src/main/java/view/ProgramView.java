package view;

import controller.Converter;

import java.io.PrintStream;
import java.util.Locale;


public class ProgramView {

    ResourceManager language;
    PrintStream printStream;

    public ProgramView() {
        language = ResourceManager.INSTANCE;
    }

    public void show() {
        System.out.println(language.getString("program.view.menu"));
    }

    public void printError(String message) {
        System.err.println(message);
    }

    public void printMessage(String message) {
        System.out.println(language.getString(message));
    }

    public void changeDefaultLanguage(String language, String country) {
        this.language.changeResource(new Locale(language, country));
    }

    public void result(String message, Converter converter) {
        System.out.println(language.getString(message));
        System.out.println(converter.toString());
    }


}
