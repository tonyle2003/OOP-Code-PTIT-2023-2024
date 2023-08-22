import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    static Map<Integer, Integer> numbers = new TreeMap<>();
    public static void main(String[] args) {
        try {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream("DATA.IN"));
            while (dataInputStream.available() > 0) {
                int temp = dataInputStream.readInt();
                if (numbers.containsKey(temp)) {
                    numbers.replace(temp, numbers.get(temp) + 1);
                } else {
                    numbers.putIfAbsent(temp, 1);
                }
            }
            dataInputStream.close();
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println(fileNotFoundException.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        numbers.forEach((key, value) -> {
            System.out.println(key + " " + value);
        });
    }
}