import java.io.*;
import java.util.*;

public class Main {
    private static final String FILE_1 = "DATA1.in";
    private static final String FILE_2 = "DATA2.in";
    private static List<Integer> list1;
    private static List<Integer> list2;
    private static Set<Integer> set1 = new TreeSet<>(), set2 = new TreeSet<>();
    public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
        list1 = getObject(FILE_1);
        set1.addAll(list1);
        list2 = getObject(FILE_2);
        set2.addAll(list2);

        int count = 0;
        for (Integer e : set1) {
            if (set2.contains(e) && isOdd(e + "")) {
                System.out.println(e + " " + (Collections.frequency(list1, e) + Collections.frequency(list2, e)));
                count++;
            }
            if (count == 10) {
                break;
            }
        }
    }   

    @SuppressWarnings("unchecked")
    static List<Integer> getObject(String fileName) throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName));
        List<Integer> list = (ArrayList<Integer>) objectInputStream.readObject();
        objectInputStream.close();
        return list;
    }

    static boolean isOdd(String number) {
        StringBuilder stringBuilder = new StringBuilder(number);
        if (!stringBuilder.reverse().toString().equals(number)) {
            return false;
        }
        if (number.length() % 2 == 0) {
            return false;
        }
        if (number.length() == 1) {
            return false;
        }
        for (int i = 0; i < number.length(); i++) {
            if (Integer.parseInt(number.charAt(i) + "") % 2 == 0) {
                return false;
            }
        }
        return true;
    }
}
