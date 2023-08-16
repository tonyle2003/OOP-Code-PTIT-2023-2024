import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    
    private static Scanner scanner = new Scanner(System.in);
    private static int test;
    private static long number;
    private static List<Long> listPrime;
    public static void main(String[] args) {
        test = scanner.nextInt();
        while (test > 0) {
            test--;
            number = scanner.nextLong();
            if (isPrime(number)) {
                System.out.println(number); 
            } else {
                listPrime = getListPrime();
                System.out.println(listPrime.get(0));
            }
        }
    }

    private static boolean isPrime(long number) {
        if (number <= 1) {
            return false;
        }
        if (number == 2 || number == 3) {
            return true;
        }
        for (long i = 2; i <= (long) Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static List<Long> getListPrime() {
        List<Long> newSet = new ArrayList<>();
        long current = 2;
        while (number != 1) {
            if (number % current == 0) {
                if (isPrime(number) && !newSet.contains(current)) {
                    newSet.add(current);
                }
                number /= current;
            } else {
                current++;
            }
        }
        newSet.sort(Comparator.reverseOrder());
        return newSet;
    }
}
