import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int size;
    static int[] array;
    public static void main(String[] args) {
        getTest();
        for (int i = 0; i < array.length; i++) {
            System.out.print("Buoc " + i + ": ");
            Arrays.sort(array, 0, i + 1);
            for (int j = 0; j <= i; j++) {
                System.out.print(array[j] + " ");
            }
            System.out.println();
        }
    }

    static void getTest() {
        size = scanner.nextInt();
        array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
    }
}
