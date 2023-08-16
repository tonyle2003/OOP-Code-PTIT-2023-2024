import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    
    private static Scanner scanner = new Scanner(System.in);
    private static int test;
    private static int n;
    public static void main(String[] args) {
        test = scanner.nextInt();
        for (int i = 1; i <= test; i++) {
            n = scanner.nextInt();
            Map<Integer, Integer> map = new LinkedHashMap<>();
            while (n > 0) {
                n--;
                int temp = scanner.nextInt();
                if (map.containsKey(temp)) {
                    map.replace(temp, map.get(temp) + 1);
                } else {
                    map.put(temp, 1);
                }
            }
            System.out.println("Test " + i + ": ");
            map.forEach((key, value) -> {
                System.out.println(key + " xuat hien " + value + " lan");
            });
        }
    }
}
