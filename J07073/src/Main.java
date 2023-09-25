import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    private static final String FILE_NAME = "MONHOC.in";
    private static List<Subject> subjects = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream(FILE_NAME));
        int n = Integer.parseInt(scanner.nextLine());
        while (n > 0) {
            n--;
            subjects.add(new Subject(
                    scanner.nextLine(),
                    scanner.nextLine(),
                    Integer.parseInt(scanner.nextLine()),
                    scanner.nextLine(),
                    scanner.nextLine()));
        }

        List<Subject> result = subjects.parallelStream()
                                    .filter(e -> e.getOnlineClassType().equals("Truc tuyen") || e.getOnlineClassType().contains(".ptit.edu.vn"))
                                    .collect(Collectors.toList());

        result.sort(Comparator.comparing(Subject::getId));

        result.forEach((e) -> System.out.println(e));
    }
}

class Subject {
    private String id;
    private String name;
    private int credit;
    private String realClassType;
    private String onlineClassType;

    public Subject(String id, String name, int credit, String realClassType, String onlineClassType) {
        this.id = id;
        this.name = name;
        this.credit = credit;
        this.realClassType = realClassType;
        this.onlineClassType = onlineClassType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getRealClassType() {
        return realClassType;
    }

    public void setRealClassType(String realClassType) {
        this.realClassType = realClassType;
    }

    public String getOnlineClassType() {
        return onlineClassType;
    }

    public void setOnlineClassType(String onlineClassType) {
        this.onlineClassType = onlineClassType;
    }

    @Override
    public String toString() {
        return this.id + " " + this.name + " " + this.credit + " " + this.realClassType + " " + this.onlineClassType;
    }
}