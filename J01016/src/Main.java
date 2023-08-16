import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static String number;

    public static void main(String[] args) {
        number = scanner.next();
        int sum = 0;
        for (int i = 0; i < number.length(); i++) {
            if (number.charAt(i) == '4' || number.charAt(i) == '7') {
                sum++;
            }
        }
        if (sum == 4 || sum == 7) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
