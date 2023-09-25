import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int test = scanner.nextInt();
        while (test > 0) {
            test--;
            System.out.println(new BigInteger(scanner.next()).add(new BigInteger(scanner.next())).toString());
        }
    }
}
