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
            String result;
            if (a.compareTo(b) > 0) {
                result = a.subtract(b).toString();
            } else {
                result = b.subtract(a).toString();
            }
            int countZero = Math.min(
                Math.abs(result.length() - a.toString().length()), 
                Math.abs(result.length() - b.toString().length())
            );
            while (countZero != 0) {
                System.out.print("0");
                countZero--;
            }
            System.out.print(result + "\n");
        }
    }
}
