import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int test = scanner.nextInt();
        while (test > 0) {
            test--;
            BigInteger n = new BigInteger(scanner.nextInt() + "");
            Queue<BigInteger> list = new LinkedList<>();
            list.add(new BigInteger("9"));
            while (list.peek().divideAndRemainder(n)[1].intValue() != 0) {
                String temp = list.peek().toString();
                list.add(new BigInteger(temp + "0"));
                list.add(new BigInteger(temp + "9"));
                list.poll();
            }
            System.out.println(list.poll().toString());
        }
    }
}
