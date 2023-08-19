import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int size;
    static int[] array;
    public static void main(String[] args) {
        getTest();
        int step = 1;
        for (int i = 0; i < array.length - 1; i++) {
            boolean check = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    check = true;
                }
            }
            if (check == true) {
                System.out.print("Buoc " + step + ": ");
                step++;
                for (int j = 0; j < array.length; j++) {
                    System.out.print(array[j] + " ");
                }
                System.out.println();
            } else {
                break;
            }
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
