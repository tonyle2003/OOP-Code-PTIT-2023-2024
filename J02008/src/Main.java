import java.math.BigInteger;
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
            BigInteger result = new BigInteger("1");
            for (int i = 1; i <= number; i++) {
                BigInteger temp = new BigInteger(i + "");
                result = result.multiply(temp).divide(result.gcd(temp));
            }
            System.out.println(result.longValue());
        }
    }   
}
