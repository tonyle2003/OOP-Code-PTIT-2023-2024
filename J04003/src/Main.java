import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(
            new PhanSo(
                new BigInteger(scanner.next()),
                new BigInteger(scanner.next())
            )
        );
    }
}

class PhanSo {
    private BigInteger tuSo;
    private BigInteger mauSo;

    public PhanSo(BigInteger tuSo, BigInteger mauSo) {
        this.tuSo = tuSo;
        this.mauSo = mauSo;
        minimalize();
    }

    private void minimalize() {
        BigInteger temp = tuSo.gcd(mauSo);
        tuSo = tuSo.divide(temp);
        mauSo = mauSo.divide(temp);
    }

    @Override
    public String toString() {
        return tuSo + "/" + mauSo;
    }
}
