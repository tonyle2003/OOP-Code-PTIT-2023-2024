import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static int n;
    private static int[] array;

    public static void main(String[] args) {
        n = scanner.nextInt();
        array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print("Buoc " + (i + 1) + ": ");
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[i]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
            for (int e : array) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}