import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int test;
    static final String MAP = "012";
    public static void main(String[] args) {
        test = scanner.nextInt();
        while (test > 0) {
            test--;
            System.out.println(checkNumber(scanner.next()));
        }
    }

    static String checkNumber(String number) {
        for (int i = 0; i < number.length(); i++) {
            if (!MAP.contains(number.charAt(i) + "")) {
                return "NO";
            }
        }
        return "YES";
    }
}
