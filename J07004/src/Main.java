import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    static Map<Integer, Integer> numbers = new TreeMap<>();
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new FileInputStream("DATA.in"));
            while (scanner.hasNext()) {
                int temp = scanner.nextInt();
                if (numbers.containsKey(temp)) {
                    numbers.replace(temp, numbers.get(temp) + 1);
                } else {
                    numbers.putIfAbsent(temp, 1);
                }
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println(fileNotFoundException.getMessage());
        }

        numbers.forEach((key, value) -> {
            System.out.println(key + " " + value);
        });
    }
}
