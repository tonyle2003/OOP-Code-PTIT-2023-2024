import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int test = scanner.nextInt();
        while (test > 0) {
            test--;

            Fraction a = new Fraction(new BigInteger(scanner.nextInt() + ""), new BigInteger(scanner.nextInt() + ""));
            Fraction b = new Fraction(new BigInteger(scanner.nextInt() + ""), new BigInteger(scanner.nextInt() + ""));
            Fraction c = a.plusBy(b); c = c.multiplyBy(c);

            System.out.println(c + " " + a.multiplyBy(b).multiplyBy(c));
        }
    }
}

class Fraction {

    private BigInteger numerator;
    private BigInteger denominator;

    public Fraction(BigInteger numerator, BigInteger denominator) {
        BigInteger gcd = numerator.gcd(denominator);
        this.numerator = numerator.divide(gcd);
        this.denominator = denominator.divide(gcd);
    }

    public Fraction multiplyBy(Fraction fraction) {
        return new Fraction(this.numerator.multiply(fraction.numerator),
                this.denominator.multiply(fraction.denominator));
    }

    public Fraction plusBy(Fraction fraction) {
        BigInteger resultDenominator = this.denominator.gcd(fraction.denominator);
        resultDenominator = this.denominator.multiply(fraction.denominator).divide(resultDenominator);

        BigInteger resultNumerator = this.numerator.multiply(resultDenominator.divide(this.denominator))
                .add(fraction.numerator.multiply(resultDenominator.divide(fraction.denominator)));

        return new Fraction(resultNumerator, resultDenominator);
    }

    @Override
    public String toString() {
        return numerator.toString() + "/" + denominator.toString();
    }

    public BigInteger getNumerator() {
        return numerator;
    }

    public void setNumerator(BigInteger numerator) {
        this.numerator = numerator;
    }

    public BigInteger getDenominator() {
        return denominator;
    }

    public void setDenominator(BigInteger denominator) {
        this.denominator = denominator;
    }
}