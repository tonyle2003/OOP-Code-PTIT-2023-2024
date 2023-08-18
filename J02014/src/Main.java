import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int test;
    static int size;
    static int[] array;
    public static void main(String[] args) {
        test = scanner.nextInt();
        while (test > 0) {
            test--;
            size = scanner.nextInt();
            array = new int[size];
            int rightSum = 0;
            for (int i = 0; i < size; i++) {
                array[i] = scanner.nextInt();
                rightSum += array[i];
            }
            rightSum -= array[0];
            int leftSum = 0;
            int index = -1;
            for (int i = 1; i < size; i++) {
                rightSum -= array[i];
                leftSum += array[i - 1];
                if (leftSum == rightSum) {
                    index = i + 1;
                    break;
                }
            }
            System.out.println(index);
        }
    }
}
