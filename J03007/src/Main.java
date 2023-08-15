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
            if (number.charAt(0) == '8' && number.charAt(number.length() - 1) == '8') {
                if (getSumDigits() % 10 == 0) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            } else {
                System.out.println("NO");
            }
        }
    }

    private static int getSumDigits() {
        int sum = 0;
        for (int i = 0; i < number.length(); i++) {
            sum += Integer.parseInt(number.charAt(i) + "");
        }
        return sum;
    }
}
