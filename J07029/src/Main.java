import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    static List<Integer> listNumbers;
    static Map<Integer, Integer> listPrimes = new TreeMap<>(Comparator.reverseOrder());

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("DATA.in"));
        listNumbers = (ArrayList<Integer>) objectInputStream.readObject();
        objectInputStream.close();
        for (Integer e : listNumbers) {
            if (isPrime(e)) {
                if (listPrimes.containsKey(e)) {
                    listPrimes.replace(e, listPrimes.get(e) + 1);
                } else {
                    listPrimes.putIfAbsent(e, 1);
                }
            }
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : listPrimes.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
            count++;
            if (count == 10) {
                break;
            }
        }
    }

    static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        if (number == 2 || number == 3) {
            return true;
        }
        if (number % 2 == 0 || number % 3 == 0) {
            return false;
        }
        for (int i = 5; i <= Math.sqrt(number); i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}
