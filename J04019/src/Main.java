import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0){
            Triangle a = new Triangle(Point.nextPoint(sc), Point.nextPoint(sc), Point.nextPoint(sc));
            if(!a.valid()){
                System.out.println("INVALID");
            } else{
                System.out.println(a.getPerimeter());
            }
        }
    }
}

class Point {

    double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public static double distance(Point a, Point b) {
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }

    public static Point nextPoint(Scanner scanner) {
        return new Point(scanner.nextDouble(), scanner.nextDouble());
    }
}

class Triangle {

    Point a, b, c;

    public Triangle(Point a, Point b, Point c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public boolean valid() {
        if (Point.distance(a, b) + Point.distance(a, c) <= Point.distance(b, c)) {
            return false;
        } else if (Point.distance(a, b) + Point.distance(b, c) <= Point.distance(a, c)) {
            return false;
        } else if (Point.distance(b, c) + Point.distance(a, c) <= Point.distance(a, b)) {
            return false;
        } else {
            return true;
        }
    }

    public String getPerimeter() {
        return String.format("%.3f", Point.distance(a, b) + Point.distance(a, c) + Point.distance(b, c));
    }
}