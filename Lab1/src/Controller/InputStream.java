package Controller;

import java.util.Scanner;

public class InputStream {

    public void option() {
        Scanner input = new Scanner(System.in);
        String option = input.nextLine();
        Controller checkCall = new Controller();
        checkCall.setOption(option);
    }

}
