import java.util.Arrays;
import java.util.Scanner;

public class Main {
    
    private static Scanner scanner = new Scanner(System.in);
    private static int n, m;
    private static int[] array;
    private static int[] map = new int[1005];
    public static void main(String[] args) {
        n = scanner.nextInt();
        m = scanner.nextInt();

        array = getArray(n + m);
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            if (map[array[i]] == 1) {
                System.out.print(array[i] + " ");
                map[array[i]] = 0;
            }
        }
    }

    private static int[] getArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
            map[array[i]] = 1;
        }
        return array;
    }
}
