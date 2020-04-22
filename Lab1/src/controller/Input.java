package controller;

import java.util.Scanner;

public class Input {

    private Scanner input = new Scanner(System.in);

    public Input() {

    }

    public String getUserInput() {
        return input.nextLine();
    }

}
