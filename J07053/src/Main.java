import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static final String FILE_NAME = "XETTUYEN.in";
    static List<Student> students = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream(FILE_NAME));
        int n = Integer.parseInt(scanner.nextLine());
        while (n > 0) {
            n--;
            students.add(new Student(
                    scanner.nextLine(),
                    scanner.nextLine(),
                    Double.parseDouble(scanner.nextLine()),
                    Double.parseDouble(scanner.nextLine())));
        }
        students.forEach(e -> System.out.println(e));
    }
}

class Student {

    private static final String HIDDEN_STRING = "PH";
    private static int hiddenNumber = 0;

    private String id;
    private String fullName;
    private String dob;
    private double grade1, grade2;

    public Student(String fullName, String dob, double grade1, double grade2) {
        this.id = makeId();
        this.fullName = formatName(fullName);
        this.dob = formatDate(dob);
        this.grade1 = grade1;
        this.grade2 = grade2;
    }

    private String getResult() {
        switch (getAverage()) {
            case 9:
            case 10:
                return "Xuat sac";
            case 8:
                return "Gioi";
            case 7:
                return "Kha";
            case 6:
            case 5:
                return "Trung binh";
            default:
                return "Truot";
        }
    }

    private int getAge() {
        return 2021 - Integer.parseInt(dob.split("/")[2]);
    }

    private int getAverage() {
        int temp = (int) Math.round((this.grade1 + this.grade2) / 2 + getBonus());
        return temp > 10 ? 10 : temp;
    }

    private double getBonus() {
        if (this.grade1 >= 8 && this.grade2 >= 8) {
            return 1;
        } else if (this.grade1 >= 7.5 && this.grade2 >= 7.5) {
            return 0.5;
        } else {
            return 0;
        }
    }

    private String formatDate(String date) {
        String[] numbers = date.split("/");
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i].length() == 1) {
                numbers[i] = "0" + numbers[i];
            }
        }
        return numbers[0] + "/" + numbers[1] + "/" + numbers[2];
    }

    private String formatName(String fullName) {
        String[] words = fullName.trim().split("\\s+");
        StringBuilder stringBuilder = new StringBuilder("");
        for (String word : words) {
            stringBuilder.append(
                    word.substring(0, 1).toUpperCase() +
                            word.substring(1).toLowerCase() + " ");
        }
        return stringBuilder.toString().trim();
    }

    private String makeId() {
        hiddenNumber++;
        return hiddenNumber < 10 ? HIDDEN_STRING + "0" + hiddenNumber : HIDDEN_STRING + hiddenNumber;
    }

    @Override
    public String toString() {
        return id + " " + fullName + " " + getAge() + " " + getAverage() + " " + getResult();
    }

}