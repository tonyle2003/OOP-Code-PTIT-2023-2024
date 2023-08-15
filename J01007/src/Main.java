import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static int test;
    private static long n;
    private static long[] arrayFibo = new long[101];
    public static void main(String[] args) {
        init();
        test = scanner.nextInt();
        while (test > 0) {
            test--;
            n = scanner.nextLong();
            if (isFibo()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean isFibo() {
        for (int i = 0; i < arrayFibo.length; i++) {
            if (n == arrayFibo[i]) {
                return true;
            }
        }
        return false;
    }

    private static void init() {
        arrayFibo[0] = 1L;
        arrayFibo[1] = 1L;
        for (int i = 2; i < 100; i++) {
            arrayFibo[i] = arrayFibo[i - 1] + arrayFibo[i - 2];
        }
    }
}
