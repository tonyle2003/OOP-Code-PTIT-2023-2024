import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    static Set<String> result = new TreeSet<>();
    static int size;
    static int[] binary;
    static int[] array;
    static boolean isEnd = false;
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        getTest();
        while (!isEnd) {
            if (isIncrease()) {
                saveResult();
            }
            generate();
        }
        result.forEach(e -> System.out.println(e));
    }

    static void saveResult() {
        String temp = "";
        for (int i = 0; i < array.length; i++) {
            if (binary[i] == 1) {
                temp += array[i] + " ";
            }
        }
        result.add(temp);
    }

    static void getTest() {
        size = scanner.nextInt();
        binary = new int[size];
        array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
            binary[i] = 0;
        }
    }

    static boolean isIncrease() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < binary.length; i++) {
            if (binary[i] == 1) {
                numbers.add(array[i]);
            }
        }
        for (int i = 0; i < numbers.size() - 1; i++) {
            if (numbers.get(i) > numbers.get(i + 1)) {
                return false;
            }
        }
        return numbers.size() >= 2;
    }

    static void generate() {
        int index = binary.length - 1;
        while (index >= 0 && binary[index] != 0) {
            binary[index] = 0;
            index--;
        }
        if (index < 0) {
            isEnd = true;
        } else {
            binary[index] = 1;
        }
    }
}
