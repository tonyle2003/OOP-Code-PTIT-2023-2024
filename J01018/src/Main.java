import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int test;
    public static void main(String[] args) {
        test = scanner.nextInt();
        while (test > 0) {
            System.out.println(checkNumber(scanner.next()));
            test--;
        }
    }

    static String checkNumber(String number) {
        int sum = 0;
        for (int i = 0; i < number.length() - 1; i++) {
            if (Math.abs(Integer.parseInt(number.charAt(i) + "") - Integer.parseInt(number.charAt(i + 1) + "")) != 2) {
                return "NO";
            }
            sum += Integer.parseInt(number.charAt(i) + "");
        }
        if ((sum + Integer.parseInt(number.charAt(number.length() - 1) + "")) % 10 != 0) {
            return "NO";
        } else {
            return "YES";
        }
    }
}
