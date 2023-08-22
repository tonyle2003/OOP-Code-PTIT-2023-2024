import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner readerFile = new Scanner(new FileInputStream("DATA.in"));
            while (readerFile.hasNext()) {
                System.out.println(readerFile.nextLine());
            }
        } catch (FileNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
