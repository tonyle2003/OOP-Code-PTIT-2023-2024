import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static int test;

    public static void main(String[] args) {
        test = scanner.nextInt();
        while (test > 0) {
            test--;
            System.out.println(
                new Triangle(
                    new Point(scanner.nextDouble(), scanner.nextDouble()),
                    new Point(scanner.nextDouble(), scanner.nextDouble()),
                    new Point(scanner.nextDouble(), scanner.nextDouble())
                ).getPerimeter()
            );
        }
    }
}

class Triangle {
    private Point p1, p2, p3;
    private double edge1, edge2, edge3;

    public Triangle(Point p1, Point p2, Point p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        edge1 = Point.distance(p1, p2);
        edge2 = Point.distance(p1, p3);
        edge3 = Point.distance(p2, p3);
    }

    private boolean isValid() {
        if (edge1 + edge2 <= edge3) {
            return false;
        }
        if (edge1 + edge3 <= edge2) {
            return false;
        }
        if (edge2 + edge3 <= edge1) {
            return false;
        }
        return true;
    }

    public String getPerimeter() {
        if (isValid()) {
            return String.format("%.3f", edge1 + edge2 + edge3);
        } else {
            return "INVALID";
        }
    }
}

class Point {
    private double x;
    private double y;

    public Point() {
        this(0, 0);
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point obj) {
        this(obj.x, obj.y);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double distance(Point obj) {
        return Math.sqrt(
                Math.abs(this.x - obj.x) * Math.abs(this.x - obj.x) +
                        Math.abs(this.y - obj.y) * Math.abs(this.y - obj.y));
    }

    public static double distance(Point obj1, Point obj2) {
        return Math.sqrt(
                Math.abs(obj1.x - obj2.x) * Math.abs(obj1.x - obj2.x) +
                        Math.abs(obj1.y - obj2.y) * Math.abs(obj1.y - obj2.y));
    }
}