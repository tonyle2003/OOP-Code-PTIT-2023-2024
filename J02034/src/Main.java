import java.util.Arrays;
import java.util.Scanner;

public class Main {
    
    static Scanner scanner = new Scanner(System.in);
    static int size;
    static int[] array;

    public static void main(String[] args) {
        size = scanner.nextInt();
        array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }

        Arrays.sort(array);
        int[] result = new int[array[array.length - 1] + 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = 0;
        }
        for (int i = 0; i < array.length; i++) {
            result[array[i]] = 1;
        }
        boolean isExcellent = true;
        for (int i = 1; i < result.length; i++) {
            if (result[i] == 0) {
                System.out.println(i);
                isExcellent = false;
            }
        }
        if (isExcellent) {
            System.out.println("Excellent!");
        }
    }
}
