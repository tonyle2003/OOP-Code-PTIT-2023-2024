import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    
    private static Scanner scanner = new Scanner(System.in);
    private static int test;
    private static int n;
    public static void main(String[] args) {
        test = scanner.nextInt();
        long sum = 0;
        while (test > 0) {
            test--;
            n = scanner.nextInt();
            Map<Integer, Integer> key = getMap();
            for (Integer e : key.keySet()) {
                sum += e * key.get(e);
            }
        }
        System.out.println(sum);
    }

    private static Map<Integer, Integer> getMap() {
        Map<Integer, Integer> newMap = new HashMap<>();
        int current = 2;
        while (n != 1) {
            if (n % current == 0) {
                n /= current;
                if (newMap.containsKey(current) == false) {
                    newMap.put(current, 1);
                } else {
                    newMap.replace(current, newMap.get(current) + 1);
                }
            } else {
                current++;
            }
        }
        return newMap;
    }
}