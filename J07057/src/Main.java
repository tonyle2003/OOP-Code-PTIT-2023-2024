import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    static final String FILE_NAME = "THISINH.in";
    static Set<Student> students = new TreeSet<>(
        new Comparator<Student>() {

            private int compareId(Student student1, Student student2) {
                return student1.getId().compareTo(student2.getId());
            }

            @Override
            public int compare(Student student1, Student student2) {
                int temp = Double.compare(student2.getTotalGrade(), student1.getTotalGrade());
                return temp == 0 ? compareId(student1, student2) : temp;
            }

        }
    );

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream(FILE_NAME));
        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            students.add(new Student(
                scanner.nextLine(), 
                Double.parseDouble(scanner.nextLine()), 
                scanner.nextLine(), 
                Integer.parseInt(scanner.nextLine())
            ));
        }
        students.forEach(e -> System.out.println(e));
    }
}

class Student {
    private static int hiddenNumber = 0;
    private String id;
    private String name;
    private double grade;
    private String type;
    private int place;

    public Student(String name, double grade, String type, int place) {
        this.id = makeId();
        this.name = formatName(name);
        this.grade = grade;
        this.type = type;
        this.place = place;
    }

    public String getId() {
        return this.id;
    }

    private String formatName(String name) {
        String[] words = name.trim().split("\\s+");
        StringBuilder stringBuilder = new StringBuilder("");
        for (String word : words) {
            stringBuilder.append(
                word.substring(0, 1).toUpperCase() +
                word.substring(1).toLowerCase() + " "  
            );
        }
        return stringBuilder.toString().trim();
    }

    private String makeId() {
        hiddenNumber++;
        return hiddenNumber < 10 ? "TS0" + hiddenNumber : "TS" +  hiddenNumber;
    }

    private double getBonus() {
        double bonus1, bonus2;
        if (this.place == 1) {
            bonus1 = 1.5;
        } else if (this.place == 2) {
            bonus1 = 1;
        } else {
            bonus1 = 0;
        }

        if (this.type.equals("Kinh")) {
            bonus2 = 0;
        } else {
            bonus2 = 1.5;
        }

        return bonus1 + bonus2;
    }

    public double getTotalGrade() {
        return this.grade + getBonus();
    }

    private String getResult() {
        return getTotalGrade() >= 20.5 ? "Do" : "Truot";
    }

    @Override
    public String toString() {
        return String.format("%s %s %.1f %s", id, name, getTotalGrade(), getResult());
    }
}
