import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static int test;
    static int n;
    static int[] array;
    static boolean[] check;
    public static void main(String[] args) {
        test = scanner.nextInt();
        while (test > 0) {
            test--;
            n = scanner.nextInt();
            array = new int[n];
            check = new boolean[n + 1];
            findNext(0);
        }
    }

    static void findNext(int index) {
        for (int i = 0; i < array.length; i++) {
            if (check[i] == false) {
                check[i] = true;
                array[index] = i + 1;
                if (index == array.length - 1 && checkArray()) {
                    printArray();
                } else {
                    findNext(index + 1);
                }
                check[i] = false;
            }
        }
    }

    static void printArray() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
        System.out.println();
    }

    static boolean checkArray() {
        for (int i = 0; i < array.length - 1; i++) {
            if (Math.abs(array[i] - array[i + 1]) == 1) {
                return false;
            }
        }
        return true;
    }
}