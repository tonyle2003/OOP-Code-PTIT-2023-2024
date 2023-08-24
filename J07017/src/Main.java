import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("DATA.in"));
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            boolean check = false;
            for (int i = 2; i <= 2 * Math.sqrt(n); i++) {
                Pair<Integer, Integer> p = new Pair<>(i, n - i);
                if (p.isPrime()) {
                    System.out.println(p);
                    check = true;
                    break;
                }
            }
            if (!check)
                System.out.println(-1);
        }
    }
}

@SuppressWarnings("all")
class Pair<T extends Integer, U extends T> {
    T a;
    U b;

    public Pair(T a, U b) {
        this.a = a;
        this.b = b;
    }

    public boolean isPrime() {
        return prime(a) == 1 && prime(b) == 1;
    }

    private int prime(T n) {
        if (n < 2)
            return 0;
        if (n == 2 || n == 3)
            return 1;
        if (n % 2 == 0 || n % 3 == 0)
            return 0;
        for (int i = 5; i <= Math.sqrt(n); i += 6) {
            if (n % i == 0 || n % (i + 2) == 0)
                return 0;
        }
        return 1;
    }

    @Override
    public String toString() {
        return (a + " " + b);
    }
}