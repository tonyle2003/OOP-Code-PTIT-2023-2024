import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Set<String> listChar = new HashSet<>(
            Arrays.asList(scanner.nextLine().split(""))
        );
        System.out.println(listChar.size());
    }
}
