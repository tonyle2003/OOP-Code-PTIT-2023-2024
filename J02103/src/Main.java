import java.util.Scanner;

public class Main {
    static long test;
    static int n, m;
    static long[][] maxtrix;
    static long[][] transformedMaxtrix;
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        test = scanner.nextLong();
        for (int i = 1; i <= test; i++) {
            getMatrix();
            System.out.println("Test " + i + ":");
            multiplyMatrix();
        }
    }

    static void multiplyMatrix() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                long temp = 0;
                for (int k = 0; k < m; k++) {
                    temp += maxtrix[i][k] * transformedMaxtrix[k][j];
                }
                System.out.print(temp + " ");
            }
            System.out.println();
        }
    }

    static void getMatrix() {
        n = scanner.nextInt();
        m = scanner.nextInt();
        maxtrix = new long[n][m];
        transformedMaxtrix = new long[m][n];
        for (int i = 0; i < maxtrix.length; i++) {
            for (int j = 0; j < maxtrix[i].length; j++) {
                maxtrix[i][j] = scanner.nextLong();
                transformedMaxtrix[j][i] = maxtrix[i][j];
            }
        }
    }
}
