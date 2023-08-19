import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int test;
    public static void main(String[] args) {
        test = scanner.nextInt();
        while (test > 0) {
            test--;
            System.out.println(checkSymmetricString(scanner.next()));
        }
    }

    static String checkSymmetricString(String string) {
        int left = 0, right = string.length() - 1;
        int count = 0;
        while (left <= right) {
            if (string.charAt(left) != string.charAt(right)) {
                count++;
                if (count >= 2) {
                    return "NO";
                }
            }
            left++;
            right--;
        }
        if (string.length() % 2 == 0 && count == 1) {
            return "YES";
        } else if (string.length() % 2 == 1 && count < 2) {
            return "YES";
        }
        return "NO";
    } 
}
