import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int test;
    static String boardNumber;
    static Scanner scanner = new Scanner(System.in);
    static List<String> number;
    public static void main(String[] args) {
        test = scanner.nextInt();
        while (test > 0) {
            test--;
            boardNumber = scanner.next();
            number = getList();
            // System.out.println(number);
            if (
                check68(number.get(0)) ||
                checkDigitsEqualing(number.get(0)) ||
                checkIncrease(number.get(0)) ||
                (checkDigitsEqualing(number.get(1)) && checkDigitsEqualing(number.get(2)))
            ) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    static List<String> getList() {
        List<String> list = new ArrayList<>(
                Arrays.asList(boardNumber.split("-")));
        list.remove(0);
        list.addAll(Arrays.asList(
                list.get(0).split("\\.")));
        list.add(1, list.get(0).replace(".", ""));
        list.remove(0);
        return list;
    }

    static boolean check68(String number) {
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == '6') {
                continue;
            } else if (number.charAt(i) == '8') {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    static boolean checkIncrease(String number) {
        for (int i = 0; i < number.length() - 1; i++) {
            if (number.charAt(i) >= number.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }

    static boolean checkDigitsEqualing(String number) {
        for (int i = 0; i < number.length() - 1; i++) {
            if (number.charAt(i) != number.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }
}
