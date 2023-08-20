import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(new Student(
            scanner.nextLine(), 
            scanner.next(), 
            scanner.nextDouble(), 
            scanner.nextDouble(),
            scanner.nextDouble() 
        ));
    }
}

class Student {
    private String fullName;
    private String DoB;
    private double subject1;
    private double subject2;
    private double subject3;

    public Student(String fullName, String doB, double subject1, double subject2, double subject3) {
        this.fullName = fullName;
        DoB = doB;
        this.subject1 = subject1;
        this.subject2 = subject2;
        this.subject3 = subject3;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.1f", fullName, DoB, subject1 + subject2 + subject3);
    }
}