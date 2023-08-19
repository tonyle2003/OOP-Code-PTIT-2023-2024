import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int test;

    public static void main(String[] args) {
        test = scanner.nextInt();
        scanner.nextLine();
        while (test > 0) {
            test--;
            List<String> listWords = new ArrayList<>(Arrays.asList(scanner.nextLine().split(" ")));
            for (String e : listWords) {
                StringBuilder stringBuilder = new StringBuilder(e);
                System.out.print(stringBuilder.reverse() + " ");
            }
            System.out.println();
        }
    }
}
