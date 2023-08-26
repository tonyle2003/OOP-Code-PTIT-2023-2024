import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    static final String FILE_NAME = "DN.in";
    static int n;
    static Set<Company> companies = new TreeSet<>();

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream(FILE_NAME));
        n = Integer.parseInt(scanner.nextLine());
        while (n > 0) {
            n--;
            companies.add(new Company(
                scanner.nextLine(), 
                scanner.nextLine(), 
                Integer.parseInt(scanner.nextLine())
            ));
        }
        companies.forEach(e -> System.out.println(e));
    }
}

class Company implements Comparable<Company> {
    private String id;
    private String name;
    private int slot;

    public Company(String id, String name, int slot) {
        this.id = id;
        this.name = name;
        this.slot = slot;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + slot;
    }

    @Override
    public int compareTo(Company other) {
        return this.id.compareTo(other.id);
    }

}