import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static int width;
    private static int height;

    public static void main(String[] args) {
        try {
            getTest();
            System.out.println(((width + height) * 2) + " " + (width * height));
        } catch (ZeroLengthException zeroLengthException) {
            System.out.println(zeroLengthException.getMessage());
        } catch (InputMismatchException inputMismatchException) {
            System.out.println(inputMismatchException.getMessage());
        }
    }

    private static void getTest() throws ZeroLengthException, InputMismatchException {

        try {
            width = scanner.nextInt();
            height = scanner.nextInt();
            if (width <= 0 || height <= 0) {
                throw new ZeroLengthException("0");
            }
        } catch (InputMismatchException inputMismatchException) {
            throw new InputMismatchException("Invalid input. Please enter valid integers.");
        }
    }

}

class ZeroLengthException extends RuntimeException {

    public ZeroLengthException() {
        super();
    }

    public ZeroLengthException(String message) {
        super(message);
    }
}