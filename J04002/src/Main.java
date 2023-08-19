import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int a, b;
    static String color;
    public static void main(String[] args) {
        a = scanner.nextInt();
        b = scanner.nextInt();
        color = scanner.next();
        if (a <= 0 || b <= 0) {
            System.out.println("INVALID");
        } else {
            System.out.println(
                Retangle.calculatePerimeter(a, b) + " " +
                Retangle.calcualteArea(a, b) + " " +
                color.substring(0, 1).toUpperCase() + color.substring(1, color.length()).toLowerCase()
            );
        }
    }
}

class Retangle {
    static int calculatePerimeter(int a, int b) {
        return (a + b) * 2;
    }

    static int calcualteArea(int a, int b) {
        return a * b;
    }
}
