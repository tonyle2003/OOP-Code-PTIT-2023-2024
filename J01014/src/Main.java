import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static int test;
    public static void main(String[] args) {
        test = scanner.nextInt();
        while (test > 0) {
            test--;
            System.out.println(getMaxPrime(scanner.nextLong()));
        }
    }
    
    private static long getMaxPrime(long number) {
        long max = 0;
        for (long i = 2; i <= Math.sqrt(number); i++) {
            while (number % i == 0) {
                number /= i;
                max = Math.max(max, i);
            }
        }
        return Math.max(max, number);
    }
}
