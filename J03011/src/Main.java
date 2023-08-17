import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int test;
    static BigInteger a, b;
    public static void main(String[] args) {
        test = scanner.nextInt();
        while (test > 0) {
            test--;
            a = new BigInteger(scanner.next());
            b = new BigInteger(scanner.next());
            BigInteger temp = a.multiply(b);
            System.out.println(temp.divide(temp.divide(a.gcd(b))));
        }
    }
}
