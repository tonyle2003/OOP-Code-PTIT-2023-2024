import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int test = scanner.nextInt();
        while (test > 0) {
            test--;
            int n = scanner.nextInt();
            System.out.println(size(n));
            Queue<String> queue = new LinkedList<>();
            queue.add("6");
            queue.add("8");
            List<String> result = new ArrayList<>();
            while (queue.peek().length() <= n) {
                result.add(queue.peek());
                queue.add(queue.peek() + "6");
                queue.add(queue.peek() + "8");
                queue.poll();
            }
            for (int i = result.size() - 1; i >= 0; i--) {
                System.out.print(result.get(i) + " ");
            }
            System.out.println();
        }
    }

    private static int size(int n) {
        if (n == 0) {
            return 0;
        }
        return (int) Math.pow(2, n) + size(n - 1);
    }
}
