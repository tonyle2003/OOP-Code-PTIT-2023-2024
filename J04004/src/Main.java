import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        PhanSo a = new PhanSo(
            new BigInteger(scanner.nextInt() + ""),
            new BigInteger(scanner.nextInt() + "")
        );
        PhanSo b = new PhanSo(
            new BigInteger(scanner.nextInt() + ""),
            new BigInteger(scanner.nextInt() + "")
        );
        System.out.println(a.add(b));
    }
}

class PhanSo {
    private BigInteger tuSo;
    private BigInteger mauSo;

    public PhanSo() {
        this(new BigInteger("0"), new BigInteger("1"));
    }

    public PhanSo(BigInteger tuSo, BigInteger mauSo) {
        this.tuSo = tuSo;
        this.mauSo = mauSo;
        rutGon();
    }

    public PhanSo add(PhanSo other) {
        BigInteger mauSoResult = this.mauSo.multiply(other.mauSo).divide(this.mauSo.gcd(other.mauSo));
        BigInteger tuSoResult = 
            this.tuSo.multiply(mauSoResult.divide(this.mauSo)).add(other.tuSo.multiply(mauSoResult.divide(other.mauSo)));
        return new PhanSo(tuSoResult, mauSoResult);
    }

    private void rutGon() {
        BigInteger temp = tuSo.gcd(mauSo);
        tuSo = tuSo.divide(temp);
        mauSo = mauSo.divide(temp);
    }

    @Override
    public String toString() {
        return this.tuSo + "/" + this.mauSo;
    }
}
