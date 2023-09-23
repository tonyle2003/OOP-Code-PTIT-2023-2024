import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int test = scanner.nextInt();
        scanner.nextLine();
        while (test > 0) {
            test--;
            System.out.println(new Student(
                    scanner.nextLine(),
                    scanner.nextLine(),
                    scanner.nextLine(),
                    Double.parseDouble(scanner.nextLine())));
        }
    }
}

class Student {

    private static Integer hiddenId = 0;
    private String id;
    private String fullName;
    private String _class;
    private String dob;
    private double gpa;

    public Student(String fullName, String _class, String dob, double gpa) {
        this.id = makeId();
        this.fullName = fullName;
        this._class = _class;
        this.dob = formatDate(dob);
        this.gpa = gpa;
    }

    private String makeId() {
        hiddenId++;
        String temp;
        if (hiddenId < 10) {
            temp = "00" + hiddenId;
        } else {
            temp = "0" + hiddenId;
        }
        return "B20DCCN" + temp;
    }

    private String formatDate(String dob) {
        String[] temp = dob.split("/");
        StringBuffer result = new StringBuffer("");
        for (String s : temp) {
            if (s.length() == 1) {
                result.append("0" + s + "/");
            } else {
                result.append(s + "/");
            }
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %.2f", this.id, this.fullName, this._class, this.dob, this.gpa);
    }

}