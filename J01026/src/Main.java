import java.util.Scanner;

public class Main {
    
    private static Scanner scanner = new Scanner(System.in);
    private static int test;
    private static int number;
    public static void main(String[] args) {
        test = scanner.nextInt();
        while (test > 0) {
            number = scanner.nextInt();
            if ((int)Math.sqrt(number) * (int)Math.sqrt(number) == number) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            test--;
        }
    }
}
