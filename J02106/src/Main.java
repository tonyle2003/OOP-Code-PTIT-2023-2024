import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int size;
    static int[][] array;
    public static void main(String[] args) {
        size = scanner.nextInt();
        array = new int[size][3];
        int count = 0;
        for (int i = 0; i < size; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                array[i][j] = scanner.nextInt();
                if (array[i][j] == 1) {
                    list.add(array[i][j]);
                }
            }
            if (list.size() >= 2) {
                count++;
            }
        }
        System.out.println(count);
    }
}
