package controller;

import java.util.Scanner;

<<<<<<< Updated upstream
<<<<<<< Updated upstream
public class Input {

    private Scanner input = new Scanner(System.in);

    public Input() {

    }

    public String getUserInput() {
=======
class Input {

    private Scanner input = new Scanner(System.in);

    Input() {

    }

    String getUserInput() {
>>>>>>> Stashed changes
=======
public class Input {

    private Scanner input;

    public Input() {
        input = new Scanner(System.in);
    }

    public String getUserInput() {
>>>>>>> Stashed changes
        return input.nextLine();
    }

}
