import exceptions.InvalidSize;
import exceptions.SizeExceededException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введіть розмір списку:");
        int size;
        while (true) {
            try {
                size = scan.nextInt();
                checkSize(size);
            } catch (InputMismatchException|InvalidSize e) {
                System.err.println("Будь ласка, введіть невід'ємне ціле число. ");
                scan.nextLine();
                continue;
            }
            scan.nextLine();
            break;
        }
        List<Integer> integers = createList(size);
        System.out.println("Даний список:");
        System.out.println(integers);
        System.out.println("Введіть к-сть зсувів:");
        int shifts;
        while (true) {
            try {
                shifts = scan.nextInt();
                checkShiftsAmount(shifts, integers.size());
            } catch (InputMismatchException | SizeExceededException E) {
                System.err.println("Будь ласка, введіть кількість зсувів в межах списку!");
                scan.nextLine();
                continue;
            }
            scan.close();
            break;
        }
        if (shifts == 0 || shifts % integers.size() == 0) {
            System.out.println("Список не змінився.");
        }
        else if (shifts > 0) {
            System.out.println("Список після " + Math.abs(shifts) + " зсувів вправо:");
        } else {
            System.out.println("Список після " + Math.abs(shifts) + " зсувів вліво:");
        }
        doShifts(integers, shifts);
        System.out.println(integers);
    }

    public static List<Integer> createList(int n) {
        List<Integer> integers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            integers.add(new Random().nextInt(10) + 1);
        }
        return integers;
    }

    public static void checkShiftsAmount(int shifts, int size) throws SizeExceededException {
        if (Math.abs(shifts) > size) {
            throw new SizeExceededException("");
        }
    }

    public static void doShifts(List<Integer> integers, int shifts) {
        int times = Math.abs(shifts);
        if (shifts > 0) {
            for (int i = 0; i < times; i++) {
                doSingleShift(integers, 1);
            }
        } else {
            for (int i = 0; i < times; i++) {
                doSingleShift(integers, -1);
            }
        }
    }

    public static void doSingleShift(List<Integer> integers, int identifier) {
        if (identifier == 1) {
            int last = integers.get(integers.size() - 1);
            integers.remove(integers.size() - 1);
            integers.add(0, last);
        } else {
            int first = integers.get(0);
            integers.remove(0);
            integers.add(first);
        }
    }

    public static void checkSize(int size) throws InvalidSize {
        if (size < 0) {
            throw new InvalidSize("");
        }
    }

}
