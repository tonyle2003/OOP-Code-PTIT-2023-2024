import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    static final String FILE_NAME = "BANGDIEM.in";
    static Set<Student> students = new TreeSet<>(
        new Comparator<Student>() {
            @Override
            public int compare(Student student1, Student student2) {
                return Double.compare(student2.average(), student1.average());
            } 
        }
    );

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream(FILE_NAME));
        int n = Integer.parseInt(scanner.nextLine());
        while (n > 0) {
            n--;
            students.add(new Student(
                scanner.nextLine(), 
                Double.parseDouble(scanner.nextLine()), 
                Double.parseDouble(scanner.nextLine()), 
                Double.parseDouble(scanner.nextLine())
            ));
        }
        students.forEach(System.out::println);
    }
}

class Student {
    
    private static final String HIDDEN_STRING = "SV";
    private static int hiddenNumber = 0;
    private String id;
    private String fullName;
    private double grade1, grade2, grade3;
    
    
    public Student(String fullName, double grade1, double grade2, double grade3) {
        this.id = makeId();
        this.fullName = formatName(fullName);
        this.grade1 = grade1;
        this.grade2 = grade2;
        this.grade3 = grade3;
    }

    public double average() {
        return (grade1 * 2.5 + grade2 * 3.5 + grade3 * 4) / 10;
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
        return (hiddenNumber < 10) ? HIDDEN_STRING + "0" + hiddenNumber : HIDDEN_STRING + hiddenNumber;
    }

    private String getResult() {
        double temp = average();
        if (temp >= 8) {
            return "GIOI";
        } else if (temp >= 6.5) {
            return "KHA";
        } else if (temp >= 5) {
            return "TRUNG BINH";
        } else {
            return "KEM";
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2f %s", id, fullName, average(), getResult()); 
    }
}