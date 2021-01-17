import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть назву директорії:");
        String dir = scanner.nextLine();
        while (!new File(dir).isDirectory()) {
            System.out.println("Неправильно вказано директорію. Будь ласка, спробуйте ще.");
            dir = scanner.nextLine();
        }
        new LexemeFixer(dir).run();
    }
}
