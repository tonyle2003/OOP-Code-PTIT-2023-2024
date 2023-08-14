import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static double a;
    private static double b;

    public static void main(String[] args) {
        a = scanner.nextDouble();
        b = scanner.nextDouble();
        if (a == 0 && b == 0) {
            System.out.println("VSN");
        } else if (a == 0 && b != 0) {
            System.out.println("VN");
        } else {
            System.out.format("%.2f", -b / a);
        }
    }
}
