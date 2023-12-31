import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    static final String FILE_NAME = "MONHOC.in";
    static int n;
    static Set<Subject> subjects = new TreeSet<>();
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream(FILE_NAME));
        n = Integer.parseInt(scanner.nextLine());
        while (n > 0) {
            n--;
            subjects.add(new Subject(
                scanner.nextLine(), 
                scanner.nextLine(), 
                Integer.parseInt(scanner.nextLine())
            ));
        }
        subjects.forEach(e -> System.out.println(e));
    }
}

class Subject implements Comparable<Subject> {

    private String id;
    private String name;
    private int credit;

    public Subject(String id, String name, int credit) {
        this.id = id;
        this.name = name;
        this.credit = credit;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + credit;
    }

    @Override
    public int compareTo(Subject object) {
        return this.name.compareTo(object.name);
    }
}