import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int test = scanner.nextInt();
        while (test > 0) {
            test--;
            Point point1 = new Point(scanner.nextDouble(), scanner.nextDouble());
            Point point2 = new Point(scanner.nextDouble(), scanner.nextDouble());
            Point point3 = new Point(scanner.nextDouble(), scanner.nextDouble());

            double a = Point.distance(point1, point2);
            double b = Point.distance(point1, point3);
            double c = Point.distance(point2, point3);

            if (check(a, b, c)) {
                double p = (a + b + c) / 2;
                double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
                System.out.printf("%.3f\n", Math.PI * ((a * b * c) / (4 * s)) * ((a * b * c) / (4 * s)));
            } else {
                System.out.println("INVALID");
            }
        }
    }

    private static boolean check(double a, double b, double c) {
        if (a + b <= c) {
            return false;
        } else if (a + c <= b) {
            return false;
        } else if (c + b <= a) {
            return false;
        } else {
            return true;
        }
    }
}

class Point {

    double a, b;

    public Point() {
    }

    public Point(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public Point(Point point) {
        this(point.a, point.b);
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double distance(Point point) {
        return Math.sqrt(
                (this.a - point.a) * (this.a - point.a) + (this.b - point.b) * (this.b - point.b));
    }

    public static double distance(Point point1, Point point2) {
        return Math.sqrt(
                (point1.a - point2.a) * (point1.a - point2.a) + (point1.b - point2.b) * (point1.b - point2.b));
    }
}
