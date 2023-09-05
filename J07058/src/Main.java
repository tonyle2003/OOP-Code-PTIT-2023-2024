import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    static final String FILE_NAME = "MONHOC.in";
    static Set<Subject> subjects = new TreeSet<>(new Comparator<Subject>() {

        @Override
        public int compare(Subject subject1, Subject subject2) {
            return subject1.getId().compareTo(subject2.getId());
        }

    });

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream(FILE_NAME));
        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            subjects.add(new Subject(
                scanner.nextLine(), 
                scanner.nextLine(), 
                scanner.nextLine()
            ));
        }
        subjects.forEach(e -> System.out.println(e));
    }
}

class Subject {

    private String id;
    private String name;
    private String typeExam;

    public Subject(String id, String name, String typeExam) {
        this.id = id;
        this.name = name;
        this.typeExam = typeExam;
    }

    public String getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + typeExam;
    }
}