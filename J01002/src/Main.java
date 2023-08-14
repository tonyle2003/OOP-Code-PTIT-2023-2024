import java.util.Scanner;

public class Main {
    
    private static Scanner scanner = new Scanner(System.in);
    private static int test;
    private static long n;
    public static void main(String[] args) {
        test = scanner.nextInt();
        while (test > 0) {
            test--;
            n = scanner.nextInt();
            System.out.println(n * (n + 1) / 2);
        }
    }
}
