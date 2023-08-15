import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    
    private static Scanner scanner = new Scanner(System.in);
    private static int test;
    private static String[] a, b;
    public static void main(String[] args) {
        test = scanner.nextInt();
        scanner.nextLine();
        while (test > 0) {
            test--;

            a = scanner.nextLine().split(" ");
            b = scanner.nextLine().split(" ");

            Set<String> result = new HashSet<>();
            for (int i = 0; i < a.length; i++) {
                result.add(a[i]);
            }

            for (int i = 0; i < b.length; i++) {
                if (result.contains(b[i])) {
                    result.remove(b[i]);
                }
            }

            result.forEach(e -> {
                System.out.print(e + " ");
            });
            System.out.println();
        }
    }
}
