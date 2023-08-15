import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static int test;
    private static BigInteger a, b;
    public static void main(String[] args) {
        test = scanner.nextInt();
        while (test > 0) {
            test--;
            a = new BigInteger(scanner.next());
            b = new BigInteger(scanner.next());

            System.out.println((a.multiply(b)).divide(a.gcd(b)));
        }
    }
}