import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static List<Student> students = new ArrayList<>();
    private static int num = 0;

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.nextLine();
        while (n > 0) {
            n--;
            students.add(
                    new Student(
                            makeId("B20DCCN", ++num),
                            formatName(scanner.nextLine()),
                            scanner.nextLine(),
                            formatDate(scanner.nextLine()),
                            Double.parseDouble(scanner.nextLine())));
        }
        students.sort(Comparator.comparing(Student::getGpa).reversed());
        students.forEach(e -> System.out.println(e));
    }

    private static String makeId(String stringId, int numberId) {
        return numberId < 10 ? stringId + "00" + numberId : stringId + "0" + numberId;
    }

    private static String formatDate(String date) {
        StringBuilder result = new StringBuilder();
        Arrays.asList(date.split("/"))
                .stream()
                .map(e -> e.length() == 1 ? "0" + e : e)
                .forEach(e -> result.append(e + "/"));
        return result.deleteCharAt(result.length() - 1).toString();
    }

    private static String formatName(String fullName) {
        StringBuilder result = new StringBuilder();
        Arrays.asList(fullName.trim().split("\\s+"))
                .stream()
                .forEach(word -> result
                        .append(word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase() + " "));
        return result.deleteCharAt(result.length() - 1).toString();
    }
}

class Student {

    private final String id;
    private final String fullName;
    private final String dob;
    private final String classId;
    private double gpa;

    public Student(String id, String fullName, String dob, String classId, double gpa) {
        this.id = id;
        this.fullName = fullName;
        this.dob = dob;
        this.classId = classId;
        this.gpa = gpa;
    }

    public String getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getDob() {
        return dob;
    }

    public String getClassId() {
        return classId;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %.2f", this.id, this.fullName, this.dob, this.classId, this.gpa);
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
}