package util;

import java.util.Random;

public class CredentialsRandomizer {
    public static String[] generateCredentials() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz012" +
                "3456789~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?";
        String login = "";
        String password = "";
        for (int i = 0; i < 6; i++) {
            int index = new Random().nextInt(characters.length());
            login += characters.charAt(index);
        }
        for (int i = 0; i < 8; i++) {
            int index = new Random().nextInt(characters.length());
            password += characters.charAt(index);
        }
        String[] credentials = new String[2];
        credentials[0] = login;
        credentials[1] = password;
        return credentials;
    }
}
