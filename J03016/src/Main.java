import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static BigInteger divider = new BigInteger("11");
    public static void main(String[] args) {
        int t = scanner.nextInt();
        while (t > 0) {
            t--;
            int result = new BigInteger(scanner.next()).remainder(divider).intValue();
            if (result == 0) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
