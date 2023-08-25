import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    static Set<Integer> elements1;
    static Set<Integer> elements2;

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

        elements1 = getObjectToSet("DATA1.in");
        elements2 = getObjectToSet("DATA2.in");

        for (int e : elements1) {
            if (e * 2 > 1000000) {
                break;
            }
            if (!elements2.contains(e) && !elements2.contains(1000000 - e) && elements1.contains(1000000 - e)) {
                System.out.println(e + " " + (1000000 - e));
            }
        }
    }

    @SuppressWarnings("unchecked")
    static Set<Integer> getObjectToSet(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName));
        List<Integer> list = (ArrayList<Integer>) objectInputStream.readObject();
        objectInputStream.close();
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < list.size(); i++) {
            if (isPrime(list.get(i))) {
                set.add(list.get(i));
            }
        }
        return set;
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
