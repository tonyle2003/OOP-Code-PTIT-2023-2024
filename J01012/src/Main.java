import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static int test;
    private static int n;

    public static void main(String[] args) {
        test = scanner.nextInt();
        while (test > 0) {
            test--;
            n = scanner.nextInt();
            Set<Integer> box = new HashSet<>();
            for (int i = 1; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    box.add(i);
                    if (n % (n / i) == 0) {
                        box.add(n / i);
                    }
                }
            }
            int count = 0;
            for (Integer e : box) {
                if (e % 2 == 0) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
