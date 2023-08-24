import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    static final String INPUT_FILE_NAME = "SONGUYEN.in";
    static boolean[] primeNumbers = new boolean[10000];
    static ArrayList<Integer> dataInput;
    static Map<Integer, Integer> numbersFrequency = new TreeMap<>();

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(INPUT_FILE_NAME));
        dataInput = (ArrayList<Integer>) objectInputStream.readObject();
        objectInputStream.close();
        for (Integer e : dataInput) {
            if (primeNumbers[e]) {
                if (numbersFrequency.containsKey(e)) {
                    numbersFrequency.replace(e, numbersFrequency.get(e) + 1);
                } else {
                    numbersFrequency.putIfAbsent(e, 1);
                }
            }
        }
        numbersFrequency.forEach((key, value) -> System.out.println(key + " " + value));
    }

    static int prime(int n) {
        if (n < 2)
            return 0;
        if (n == 2 || n == 3)
            return 1;
        if (n % 2 == 0 || n % 3 == 0)
            return 0;
        for (long i = 5; i <= Math.sqrt(n); i += 6) {
            if (n % i == 0 || n % (i + 2) == 0)
                return 0;
        }
        return 1;
    }
}
