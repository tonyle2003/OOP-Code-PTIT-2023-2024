import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static long n;
    private static long result = 0;
    public static void main(String[] args) {
        n = scanner.nextLong();
        long temp = 1;
        for (long i = 1; i <= n; i++) {
            temp *= i;
            result = temp + result;
        }
        System.out.println(result);
    }
}
