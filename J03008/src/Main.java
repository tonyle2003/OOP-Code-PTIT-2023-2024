import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    
    private static Scanner scanner = new Scanner(System.in);
    private static int test;
    private static String number;
    private static List<Integer> primeNumber = new ArrayList<>();
    public static void main(String[] args) {
        initPrimeNumber();
        test = scanner.nextInt();
        while (test > 0) {
            number = scanner.next();
            if (isGoodNumber()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            test--;
        }
    }
    
    private static boolean isGoodNumber() {
        int left = 0, right = number.length() - 1;
        while (left <= right) {
            if (number.charAt(left) == number.charAt(right)) {
                if (!primeNumber.contains(Integer.parseInt(number.charAt(left) + ""))) {
                    return false;
                }
            } else {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private static void initPrimeNumber() {
        primeNumber.add(2);
        primeNumber.add(3);
        primeNumber.add(5);
        primeNumber.add(7);
    }
}
