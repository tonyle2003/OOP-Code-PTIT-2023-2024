import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    static int test;
    static BigInteger a, b;
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        test = scanner.nextInt();
        while (test > 0) {
            test--;
            a = new BigInteger(scanner.next());
            b = new BigInteger(scanner.next());

            System.out.println(result());
        }
    }

    static String result() {
        if (a.remainder(b).intValue() == 0) {
            return "YES";
        } else if (b.remainder(a).intValue() == 0) {
            return "YES";
        } else {
            return "NO";
        }
    }
}