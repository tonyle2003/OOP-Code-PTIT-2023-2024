import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner readerFile = new Scanner(new FileInputStream("DATA.in"));
            long sum = 0;
            while (readerFile.hasNext()) {
                try {
                    sum += readerFile.nextInt();
                } catch (InputMismatchException inputMismatchException) {
                    readerFile.next();
                }
            }
            System.out.println(sum);
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println(fileNotFoundException.getMessage());
        }
    }
}
