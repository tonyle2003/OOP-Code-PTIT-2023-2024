import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int test;
    public static void main(String[] args) {
        test = scanner.nextInt();
        while (test > 0) {
            test--;
            System.out.println(isReverseNumber(scanner.next().toUpperCase()));
        }
    }

    static String isReverseNumber(String number) {
        int left = 0, right = number.length() - 1;
        while (left <= right) {
            if (Phone.charIndex(number.charAt(left)) != Phone.charIndex(number.charAt(right))) {
                return "NO";
            } else {
                left++;
                right--;
            }
        }
        return "YES";
    }
}

class Phone {
    private static final List<String> NUMBER = Arrays.asList(
        "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"
    );
    
    public static int charIndex(char c) {
        for (int i = 0; i < NUMBER.size(); i++) {
            if (NUMBER.get(i).contains(c + "")) {
                return i + 2;
            }
        }
        return 0;
    }
}
