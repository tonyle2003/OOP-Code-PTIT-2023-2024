import java.util.Scanner;

class ZeroLengthException extends Exception {

    public ZeroLengthException() {
        super();
    }

    public ZeroLengthException(String message, Throwable cause) {
        super(message, cause);
    }
}

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
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            System.out.println(exception.getCause());
            exception.printStackTrace();
        }
    }

    private static void getTest() throws ZeroLengthException, Exception {
        width = scanner.nextInt();
        height = scanner.nextInt();
        if (width <= 0 || height <= 0) {
            throw new ZeroLengthException("0", new Exception());
        }
    }
}
