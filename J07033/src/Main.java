import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    private static final String FILE_NAME = "SINHVIEN.in";
    private static int n;
    private static Set<Student> students = new TreeSet<>();

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream(FILE_NAME));
        n = Integer.parseInt(scanner.nextLine());
        while (n > 0) {
            n--;
            students.add(
                new Student(
                    scanner.nextLine(), 
                    scanner.nextLine(), 
                    scanner.nextLine(), 
                    scanner.nextLine()
                )
            );
        }
        students.forEach(e -> System.out.println(e));
    }
}

class Student implements Comparable<Student> {

    private String id;
    private String fullName;
    private String _class;
    private String email;

    public Student(String id, String fullName, String _class, String email) {
        this.id = id;
        this.fullName = formatName(fullName);
        this._class = _class;
        this.email = email;
    }

    private String formatName(String fullName) {
        String[] words = fullName.trim().split("\\s+");
        StringBuilder stringBuilder = new StringBuilder("");
        for (String word : words) {
            stringBuilder.append(
                    word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase() + " ");
        }
        return stringBuilder.toString().trim();
    }

    @Override
    public String toString() {
        return id + " " + fullName + " " + _class + " " + email;
    }

    @Override
    public int compareTo(Student object) {
        return this.id.compareTo(object.id);
    }

}