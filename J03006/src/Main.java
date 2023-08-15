import java.util.Scanner;

public class Main {
    
    private static Scanner scanner = new Scanner(System.in);
    private static int test;
    private static String number;
    public static void main(String[] args) {
        test = scanner.nextInt();
        while (test > 0) {
            test--;
            number = scanner.next();

            if (!isEven()) {
                System.out.println("NO");
            } else {
                if (isReverse()) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
            
        }
    }
    
    private static boolean isReverse() {
        int left, right;
        if (number.length() % 2 == 0) {
            left = number.length() / 2 - 1;
            right = number.length() / 2;
        } else {
            left = number.length() / 2 - 1;
            right = number.length() / 2 + 1;
        }
        while (left >= 0 && right < number.length()) {
            if (number.charAt(left) != number.charAt(right)) {
                return false;
            } else {
                left--;
                right++;
            }
        }
        return true;
    }

    private static boolean isEven() {
        for (int i = 0; i < number.length(); i++) {
            if (Integer.parseInt(number.charAt(i) + "") % 2 != 0) {
                return false;
            }
        }
        return true;
    }
}
