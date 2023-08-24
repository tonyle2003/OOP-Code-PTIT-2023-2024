import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    static Map<Integer, Integer> numbers = new TreeMap<>();
    static ArrayList<Integer> listNumber;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("DATA.in"));
            listNumber = (ArrayList<Integer>) objectInputStream.readObject();
            objectInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        for (Integer e : listNumber) {
            if (numbers.containsKey(e)) {
                numbers.replace(e, numbers.get(e) + 1);
            } else {
                numbers.putIfAbsent(e, 1);
            }
        }

        numbers.forEach((key, value) -> System.out.println(key + " " + value));
    }
}
