import java.util.Scanner;

public class Main {
    
    private static Scanner scanner = new Scanner(System.in);
    private static int test;
    private static int N;
    private static int H;
    public static void main(String[] args) {
        test = scanner.nextInt();
        while (test > 0) {
            test--;
            N = scanner.nextInt();
            H = scanner.nextInt();
            for (int i = 1; i < N; i++) {
                System.out.printf("%.6f ", Math.sqrt(i) * H / Math.sqrt(N));
            }
            System.out.println();
        }
    }
}
