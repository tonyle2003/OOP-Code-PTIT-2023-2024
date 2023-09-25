import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.nextLine();
        while (n > 0) {
            n--;
            students.add(new Student(
                scanner.nextLine(), 
                scanner.nextLine(), 
                scanner.nextLine(), 
                Double.parseDouble(scanner.nextLine())));
        }

        students.forEach(e -> System.out.println(e));
    }
}

class Student {
    private static int hiddenNumber = 0;
    private String id;
    private String name;
    private String _class;
    private String dob;
    private double gpa;

    public Student(String name, String _class, String dob, double gpa) {
        this.id = makeId();
        this.name = formatName(name);
        this._class = _class;
        this.dob = formatDoB(dob);
        this.gpa = gpa;
    }

    private String formatDoB(String dob) {
        String[] words = dob.split("/");
        StringBuilder stringBuilder = new StringBuilder();
        for (String word : words) {
            if (word.length() == 1) {
                stringBuilder.append("0" + word + "/");
            } else {
                stringBuilder.append(word + "/");
            }
        }
        return stringBuilder.deleteCharAt(stringBuilder.length() - 1).toString();
    }

    private String formatName(String name) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] words = name.trim().toLowerCase().split("\\s+");
        for (String word : words) {
            stringBuilder.append(word.substring(0, 1).toUpperCase() + word.substring(1) + " ");
        }
        return stringBuilder.deleteCharAt(stringBuilder.length() - 1).toString();
    }

    private String makeId() {
        hiddenNumber++;
        if (hiddenNumber < 10) {
            return "B20DCCN00" + hiddenNumber;
        } else if (hiddenNumber >= 10 && hiddenNumber < 100) {
            return "B20DCCN0" + hiddenNumber;
        } else {
            return "B20DCCN" + hiddenNumber;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String get_class() {
        return _class;
    }

    public void set_class(String _class) {
        this._class = _class;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return this.id + " " + this.name + " " + this._class + " " + this.dob + " " + String.format("%.2f", this.gpa);
    }
}
