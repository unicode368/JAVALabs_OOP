package model;

import java.util.Scanner;

public class Input {

    private Scanner input;

    public Input() {
        input = new Scanner(System.in);
    }

    public String getUserInput() {
        return input.nextLine();
    }


}
