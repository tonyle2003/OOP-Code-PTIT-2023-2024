import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int test;
    static String number;
    static final String 
    public static void main(String[] args) {
        test = scanner.nextInt();
        while (test > 0) {
            test--;
            number = scanner.next();

        }
    }

    static String check(String number) {
        int odd = 0, even = 0;
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i))
        }
    }

    static boolean isOdd(String number) {
        return number.length() % 2 == 1;
    }

    static boolean isEven(String number) {
        return number.length() % 2 == 0;
    }
}
