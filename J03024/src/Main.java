import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int test;
    static String number;
    static final String LIST_NUMBER = "0123456789";
    public static void main(String[] args) {
        test = scanner.nextInt();
        while (test > 0) {
            test--;
            System.out.println(check(scanner.next()));
        }
    }

    static String check(String number) {
        int odd = 0, even = 0;
        for (int i = 0; i < number.length(); i++) {
            if (!LIST_NUMBER.contains(number.charAt(i) + "")) {
                return "INVALID";
            } else {
                if (Integer.parseInt(number.charAt(i) + "") % 2 == 0) {
                    even++;
                } else {
                    odd++;
                }
            }
        }
        if (number.length() % 2 == 0) {
            if (even > odd) {
                return "YES";
            } else {
                return "NO";
            }
        } else {
            if (odd > even) {
                return "YES";
            } else {
                return "NO";
            }
        }
    }
}
