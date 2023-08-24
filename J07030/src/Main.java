import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    static final int MAX_ELEMENT = 100000;
    static List<Integer> object1, object2;
    static Map<Integer, Integer> result = new TreeMap<>();

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

        ObjectInputStream input1 = new ObjectInputStream(new FileInputStream("DATA1.in"));
        object1 = (ArrayList<Integer>) input1.readObject();
        input1.close();

        ObjectInputStream input2 = new ObjectInputStream(new FileInputStream("DATA2.in"));
        object2 = (ArrayList<Integer>) input2.readObject();
        input2.close();

        for (int i = 0; i < object1.size(); i++) {
            if (i * 2 > MAX_ELEMENT) {
                break;
            }
            if (result.containsKey(object1.get(i))) {
                result.replace(object1.get(i), result.get(object1.get(i)) + 1);
            } else {
                result.putIfAbsent(object1.get(i), 1);
            }
        }
    }

    
}
