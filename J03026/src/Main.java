import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int test;
    static String a, b;
    public static void main(String[] args) {
        test = scanner.nextInt();
        while (test > 0) {
            test--;
            a = scanner.next();
            b = scanner.next();
            System.out.println(a.equals(b) ? -1 : Math.max(a.length(), b.length()));
        }
    }
}
