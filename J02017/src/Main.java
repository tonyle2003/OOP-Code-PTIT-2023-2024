import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int size;
    static List<Integer> array;

    public static void main(String[] args) {
        size = scanner.nextInt();
        array = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            array.add(scanner.nextInt());
        }
        while (true) {
            boolean check = true;
            for (int i = 0; i < array.size() - 1; i++) {
                if ((array.get(i) + array.get(i + 1)) % 2 == 0) {
                    array.remove(i);
                    array.remove(i);
                    check = false;
                    break;
                }
            }
            if (check) {
                break;
            }
        }

        System.out.println(array.size());
    }
}
