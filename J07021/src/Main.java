import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    static String line;
    static String[] words;
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream("DATA.in"));
        while ((line = scanner.nextLine().trim()).equals("END") == false) {
            words = line.split("\s+");
            for (String word : words) {
                System.out.print(
                    word.substring(0, 1).toUpperCase() +
                    word.substring(1).toLowerCase() + " "
                );
            }
            System.out.println();
        }
    }
}
