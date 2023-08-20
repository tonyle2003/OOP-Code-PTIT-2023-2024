import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(new Student(
                scanner.nextLine(),
                scanner.next(),
                scanner.next(),
                scanner.nextDouble()));
    }
}

class Student {
    private final String id = "B20DCCN001";
    private String fullName;
    private String _class;
    private String dob;
    private double gpa;

    public Student(String fullName, String _class, String dob, double gpa) {
        this.fullName = fullName;
        this._class = _class;
        this.dob = formatDateOfBirth(dob);
        this.gpa = gpa;
    }

    private String formatDateOfBirth(String dob) {
        List<String> list = new ArrayList<>(Arrays.asList(dob.split("/")));
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).length() == 1) {
                list.set(i, "0" + list.get(i));
            }
        }
        return list.get(0) + "/" + list.get(1) + "/" + list.get(2);
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %.2f", id, fullName, _class, dob, gpa);
    }
}
