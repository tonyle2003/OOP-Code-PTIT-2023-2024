import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Student> students = new ArrayList<>();
    static int numberStudents;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream("SV.in"));
        numberStudents = Integer.parseInt(scanner.nextLine());
        while (numberStudents > 0) {
            numberStudents--;
            students.add(new Student(
                    scanner.nextLine(),
                    scanner.nextLine(),
                    scanner.nextLine(),
                    Double.parseDouble(scanner.nextLine())
            ));
        }
        students.forEach(System.out::println);
    }

}

class Student {
    private static final String HIDDEN_ID = "B20DCCN";
    private static int hiddenNumber = 0;
    private String id;
    private String fullName;
    private String dob;
    private String _class;
    private double gpa;

    public Student(String fullName, String _class, String dob, double gpa) {
        this.id = makeId();
        this.fullName = fullName;
        this.dob = formatDateOfBirth(dob);
        this._class = _class;
        this.gpa = gpa;
    }

    private String makeId() {
        hiddenNumber++;
        return (hiddenNumber < 10) ? HIDDEN_ID + "00" + hiddenNumber : HIDDEN_ID + "0" + hiddenNumber;
    }

    private String formatDateOfBirth(String dob) {
        String[] temp = dob.split("/");
        for (int i = 0; i < temp.length; i++) {
            if (temp[i].length() == 1) {
                temp[i] = "0" + temp[i];
            }
        }
        return temp[0] + "/" + temp[1] + "/" + temp[2];
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %.2f", id, fullName, _class, dob, gpa);
    }

}