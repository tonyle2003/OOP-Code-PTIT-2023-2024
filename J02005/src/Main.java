import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static int n, m;
    private static Set<Integer> a;
    private static int[] b;

    public static void main(String[] args) {
        n = scanner.nextInt();
        m = scanner.nextInt();

        a = getList(n);
        b = new int[m];
        for (int i = 0; i < b.length; i++) {
            b[i] = scanner.nextInt();
        }
        Arrays.sort(b);
        for (int i = 0; i < b.length; i++) {
            if (a.contains(b[i])) {
                System.out.print(b[i] + " ");
                a.remove(b[i]);
            }
        }
    }

    private static Set<Integer> getList(int size) {
        Set<Integer> newList = new HashSet<>();
        for (int i = 0; i < size; i++) {
            newList.add(scanner.nextInt());
        }
        return newList;
    }
}
