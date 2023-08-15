import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static int test;
    private static int n;

    public static void main(String[] args) {
        test = scanner.nextInt();
        while (test > 0) {
            test--;
            n = scanner.nextInt();
            if (n < 2) {
                System.out.println(1);
            } else {
                long before = 1, after = 1;
                n--;
                n--;
                while (n != 0) {
                    long temp = before;
                    before = after;
                    after = temp + before;
                    n--;
                }
                System.out.println(after);
            }
        }
    }
}
