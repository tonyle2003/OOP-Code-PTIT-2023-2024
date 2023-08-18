import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int size;
    static int[][] array;
    public static void main(String[] args) {
        size = scanner.nextInt();
        array = new int[size][size];
        for (int i = 0; i < array.length; i++) {
            System.out.printf("List(%d) = ", i + 1);
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = scanner.nextInt();
                if (array[i][j] == 1) {
                    System.out.print(j + 1 + " ");
                }
            }
            System.out.println();
        }
    }
}