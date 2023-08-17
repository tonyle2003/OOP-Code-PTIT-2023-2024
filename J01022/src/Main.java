import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static long test;
    static long[] listBinary = new long[93];
    public static void main(String[] args) {
        test = scanner.nextInt();
        init();
        while (test > 0) {
            test--;
            System.out.println(getBit(scanner.nextInt(), scanner.nextLong()));
        }
    }

    static void init() {
        listBinary[0] = 0;
        listBinary[1] = 1;
        listBinary[2] = 1;
        for (int i = 3; i < 93; i++) {
            listBinary[i] = listBinary[i - 2] + listBinary[i - 1];
        }
    }

    static long getBit(int n, long k) {
        if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else {
            int leftBinary = n - 2;
            int rightBinary = n - 1;
            if (k <= listBinary[leftBinary]) {
                return getBit(leftBinary, k);
            } else {
                return getBit(rightBinary, k - listBinary[leftBinary]);
            }
        }
    }
}
