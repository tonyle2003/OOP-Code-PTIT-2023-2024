import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<String> result = new ArrayList<>();
    static int size;
    static String[] data;
    static int[] binary;
    static int[] array;
    static boolean isEnd = false;
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream("DAYSO.in"));
        size = Integer.parseInt(scanner.nextLine());
        data = scanner.nextLine().split(" ");
        getTest();
        while (!isEnd) {
            if (isIncrease()) {
                saveResult();
            }
            generate();
        }
        result.sort(Comparator.naturalOrder());
        result.forEach(e -> System.out.println(e));
    }

    static void saveResult() {
        String temp = "";
        for (int i = 0; i < array.length; i++) {
            if (binary[i] == 1) {
                temp += array[i] + " ";
            }
        }
        if (temp.equals("") == false) {
            result.add(temp);
        }
    }

    static void getTest() {
        array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(data[i] + "");
        }
        binary = new int[size];
        Arrays.fill(binary, 0);
    }

    static boolean isIncrease() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < binary.length; i++) {
            if (binary[i] == 1) {
                numbers.add(array[i]);
            }
        }
        for (int i = 0; i <= numbers.size() - 2; i++) {
            if (numbers.get(i) >= numbers.get(i + 1)) {
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
