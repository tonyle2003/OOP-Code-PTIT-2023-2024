import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static int test;
    private static int size;
    private static int[][] array;
    public static void main(String[] args) {
        test = scanner.nextInt();
        while (test > 0) {
            test--;
            size = scanner.nextInt();
            array = new int[size][size];
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    array[i][j] = scanner.nextInt();
                }
            }
            boolean reverse = true;
            for (int i = 0; i < array.length; i++) {
                if (reverse == true) {
                    for (int j = 0; j < array[i].length; j++) {
                        System.out.print(array[i][j] + " ");
                    }
                    reverse = false;
                } else {
                    for (int j = array[i].length - 1; j >= 0; j--) {
                        System.out.print(array[i][j] + " ");
                    }
                    reverse = true;
                }
            }
            System.out.println();
        }
    }
}
