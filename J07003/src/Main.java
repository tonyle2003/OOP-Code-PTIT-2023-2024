import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    static String number;
    public static void main(String[] args) {
        try {
            Scanner reader = new Scanner(new FileInputStream("DATA.in"));
            number = reader.next();
            while (number.length() != 1) {
                BigInteger a = new BigInteger(getHalf(0, number.length() / 2));
                BigInteger b = new BigInteger(getHalf(number.length() / 2, number.length()));
                BigInteger sum = a.add(b);
                System.out.println(sum);
                number = sum.toString();
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println(fileNotFoundException.getMessage());k
        }
    }

    static String getHalf(int begin, int end) {
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = begin; i < end; i++) {
            stringBuilder.append(number.charAt(i));
        }
        return stringBuilder.toString();
    }
}
