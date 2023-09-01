import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    static final String FILE_NAME = "BANGDIEM.in";
    static List<Student> students = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream(FILE_NAME));
        int n = Integer.parseInt(scanner.nextLine());
        while (n > 0) {
            n--;
            students.add(new Student(
                    scanner.nextLine(),
                    Double.parseDouble(scanner.nextLine()),
                    Double.parseDouble(scanner.nextLine()),
                    Double.parseDouble(scanner.nextLine())));
        }
        students.sort(Comparator.naturalOrder());
        students.get(0).setRank(1);
        for (int i = 1; i < students.size(); i++) {
            if (students.get(i).getAverage() - students.get(i -1).getAverage() == 0) {
                students.get(i).setRank(students.get(i - 1).getRank());
            } else {
                students.get(i).setRank(i + 1);
            }
        }
        students.forEach(e -> System.out.println(e));
    }

}

class Student implements Comparable<Student> {

    private static final String HIDDEN_STRING = "SV";
    private static int hiddenNumber = 0;

    private String id;
    private String fullName;
    private double grade1, grade2, grade3;
    private int rank;

    public Student(String fullName, double grade1, double grade2, double grade3) {
        this.id = makeId();
        this.fullName = formatFullName(fullName);
        this.grade1 = grade1;
        this.grade2 = grade2;
        this.grade3 = grade3;
    }

    private String makeId() {
        hiddenNumber++;
        return hiddenNumber < 10 ? HIDDEN_STRING + "0" + hiddenNumber : HIDDEN_STRING + hiddenNumber;
    }

    private String formatFullName(String fullName) {
        String[] words = fullName.trim().split("\\s+");
        StringBuilder stringBuilder = new StringBuilder("");
        for (String word : words) {
            stringBuilder.append(
                    word.substring(0, 1).toUpperCase() +
                            word.substring(1).toLowerCase() + " ");
        }
        return stringBuilder.toString().trim();
    }

    public String getId() {
        return this.id;
    }

    public double getAverage() {
        return (grade1 * 3 + grade2 * 3 + grade3 * 2) / 8;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getRank() {
        return this.rank;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f %d", id, fullName, getAverage(), rank);
    }

    @Override
    public int compareTo(Student student) {
        int result = Double.compare(student.getAverage(), this.getAverage());
        return result == 0 ? compareId(student) : result;
    }

    private int compareId(Student student) {
        return this.id.compareTo(student.id);
    }
}