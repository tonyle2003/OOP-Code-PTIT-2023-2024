import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println(new BigInteger(scanner.next()).subtract(new BigInteger(scanner.next())));
    }
}
