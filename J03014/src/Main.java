import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(new BigInteger(scanner.next()).add(new BigInteger(scanner.next())).toString());
    }
}
