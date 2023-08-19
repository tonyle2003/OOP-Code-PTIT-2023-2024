import java.util.Scanner;

public class Main {
    static int minX = 1001, maxX = 0;
    static int minY = 1001, maxY = 0;
    static int x1, y1, x2, y2;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            x1 = scanner.nextInt();
            y1 = scanner.nextInt();
            x2 = scanner.nextInt();
            y2 = scanner.nextInt();

            minX = Math.min(minX, Math.min(x1, x2));
            minY = Math.min(minY, Math.min(y1, y2));
            maxX = Math.max(maxX, Math.max(x1, x2));
            maxY = Math.max(maxY, Math.max(y1, y2));
        }
        int result = Math.max(maxX - minX, maxY - minY);
        System.out.println(result * result);
    }

}
