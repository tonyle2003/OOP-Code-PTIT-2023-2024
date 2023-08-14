import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static int test;
    private static int number;
    public static void main(String[] args) {
        test = scanner.nextInt();
        while (test > 0) {
            test--;
            number = scanner.nextInt();
            if (isPrimeNumber()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean isPrimeNumber() {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
