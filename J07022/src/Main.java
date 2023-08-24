import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<String> list = new ArrayList<>();
    static int temp;
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream("DATA.in"));
        while (scanner.hasNext()) {
            try {
                temp = scanner.nextInt();
            } catch (InputMismatchException e) {
                list.add(scanner.next());
            }
        }
        list.sort(Comparator.naturalOrder());
        list.forEach(e -> System.out.print(e + " "));
    }
}
