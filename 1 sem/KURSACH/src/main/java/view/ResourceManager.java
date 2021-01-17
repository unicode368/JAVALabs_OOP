package view;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceManager {

    INSTANCE;
    private ResourceBundle resourceBundle;
    private final String RESOURSE_NAME = "trainInfo";
    ResourceManager() {
        resourceBundle = ResourceBundle.getBundle(
                RESOURSE_NAME, Locale.getDefault());

    }

    public void changeResource(Locale locale) {
        resourceBundle = ResourceBundle.getBundle(
                RESOURSE_NAME, locale);

    }

    public String getString(String key) {
        return resourceBundle.getString(key);
    }
}