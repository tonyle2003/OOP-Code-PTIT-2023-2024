import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int test;
    static String number;
    public static void main(String[] args) {
        test = scanner.nextInt();
        while (test > 0) {
            test--;
            number = scanner.next();
            if (checkNumber()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
    
    static boolean checkNumber() {
        for (int i = 0; i < number.length() - 1; i++) {
            if (Math.abs(Integer.parseInt(number.charAt(i) + "") - Integer.parseInt(number.charAt(i + 1) + "")) != 1) {
                return false;
            }
        }
        return true;
    }
}
