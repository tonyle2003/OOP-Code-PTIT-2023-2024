import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static int test;
    private static int size;
    private static int[] array;
    public static void main(String[] args) {
        test = scanner.nextInt();
        while (test > 0) {
            test--;
            array = getTest();
            System.out.println(isSymmetryArray());
        }
    }

    private static String isSymmetryArray() {
        int left, right;
        if (array.length % 2 == 0) {
            left = (array.length / 2) - 1;
            right = array.length / 2;
        } else {
            left = (array.length /  2) - 1;
            right = (array.length / 2) + 1;
        }
        while (left >= 0 && right <= array.length) {
            if (array[left] != array[right]) {
                return "NO";
            } else {
                left--;
                right++;
            }
        }
        return "YES";
    }

    private static int[] getTest() {
        size = scanner.nextInt();
        array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }
}
