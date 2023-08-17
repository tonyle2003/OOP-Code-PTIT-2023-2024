import java.util.Scanner;

public class Main {
    
    static Scanner scanner = new Scanner(System.in);
    static long a = 0, b = 0;
    static final long MODULE = (long) 1e9 + 7;

    public static void main(String[] args) {
        while (scanner.hasNext()) {
            a = scanner.nextLong();
            b = scanner.nextLong();
            if (a == 0 && b == 0) {
                break;
            }
            
            System.out.println(power(a, b));
        }
    }

    private static long power(long a, long b) { // divide and conqueror algorithm
        long temp;
        if (b == 0) {
            return 1;
        }
        if (b == 1) {
            return a % MODULE;
        }
        temp = power(a, b / 2);
        if (b % 2 == 0) {
            return (temp * temp) % MODULE;
        } else {
            return (a * ((temp * temp) % MODULE)) % MODULE;
        }
    }
}
