import java.util.Scanner;

public class Main {
    static int n, k;
    static int[] array;
    static Scanner scanner = new Scanner(System.in);
    static boolean isEnd = false;
    public static void main(String[] args) {
        init();
        int count = 0;
        while (!isEnd) {
            printArray();
            count++;
            getNext();
        }
        System.out.println("Tong cong co " + count + " to hop");
    }

    static void getNext() {
        int index = array.length - 1;
        while (index >= 0 && array[index] == n - k + index + 1) {
            index--;
        }
        if (index < 0) {
            isEnd = true;
        } else {
            array[index]++;
            for (int i = index + 1; i < array.length; i++) {
                array[i] = array[i - 1] + 1;
            }
        }
    }

    static void printArray() {
        for (int e : array) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

    static void init() {
        n = scanner.nextInt();
        k = scanner.nextInt();
        array = new int[k];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
    }
}
