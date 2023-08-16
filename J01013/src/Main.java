import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static int test;
    private static int number;
    private static boolean[] primeNumber = new boolean[2000001];
    public static void main(String[] args) {
        eratosthenesAlgorithm();
        test = scanner.nextInt();
        long sum = 0;
        while (test > 0) {
            test--;
            number = scanner.nextInt();
            if (primeNumber[number] == true) {
                sum += number;
            } else {
                sum += getSumPrime();
            }
        }
        System.out.println(sum);
    }

    private static long getSumPrime() {
        long sum = 0;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            while (number % i == 0) {
                number /= i;
                sum += i;
            }
        }
        if (number != 1) {
            sum += number;
        }
        return sum;
    }

    private static void eratosthenesAlgorithm() {
        for (int i = 0; i < 2000001; i++) {
            primeNumber[i] = true;
        }
        primeNumber[0] = primeNumber[1] = false;
        for (int i = 2; i * i < 2000001; i++) {
            if (primeNumber[i] == true) {
                for (int j = i * i; j < 2000001; j += i) {
                    primeNumber[j] = false;
                }
            }
        }
    }
}