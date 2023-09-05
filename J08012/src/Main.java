import java.util.Scanner;

public class Main {
    static int n;
    static Scanner scanner = new Scanner(System.in);
    static int countHead = 0;
    static int countTail = 0;

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        int n = scanner.nextInt();
        final int EDGE = n;
        n--;
        int head = scanner.nextInt();
        countHead++;
        int tail = scanner.nextInt();
        countTail++;

        while (n-- != 1) {
            int u = scanner.nextInt();
            if (u == head) {
                countHead++;
            }
            int v = scanner.nextInt();
            if (u == tail) {
                countTail++;
            }
        }
        if (countHead == EDGE - 1 || countTail == EDGE - 1) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
