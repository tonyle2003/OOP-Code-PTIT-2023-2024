import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        try {
            File file = new File("Hello.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            scanner.close();
        } catch (FileNotFoundException exception1) {
            exception1.printStackTrace();
        } catch (Exception exception2) {
            exception2.printStackTrace();
        }
    }
}
