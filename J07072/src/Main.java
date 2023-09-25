import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<Name> names = new ArrayList<>();
    private static String FILE_NAME = "DANHSACH.in";

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream(FILE_NAME));

        while (scanner.hasNextLine()) {
            names.add(new Name(scanner.nextLine()));
        }

        names.sort(
            (Name name1, Name name2) -> {
                if (name1.getFirstName().equals(name2.getFirstName()) == false) {
                    return name1.getFirstName().compareTo(name2.getFirstName());
                } else if (name1.getLastName().equals(name2.getLastName()) == false) {
                    return name1.getLastName().compareTo(name2.getLastName());
                } else {
                    return name1.getMiddleName().compareTo(name2.getMiddleName());
                }
            }
        );

        names.forEach(e -> System.out.println(e.getFullName()));
    }
}

class Name {
    private String firstName;
    private String lastName;
    private String middleName;

    public Name() {
        this(null, null, null);
    }

    public Name(String lastName, String middleName, String firstName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
    }

    public Name(String fullName) {
        String[] words = fullName.trim().toLowerCase().split("\\s+");
        this.lastName = words[0].substring(0, 1).toUpperCase() + words[0].substring(1);
        this.firstName = words[words.length - 1].substring(0, 1).toUpperCase() + words[words.length - 1].substring(1);
        StringBuffer maker = new StringBuffer();
        for (int i = 1; i < words.length - 1; i++) {
            maker.append(words[i].substring(0, 1).toUpperCase() + words[i].substring(1) + " ");
        }
        this.middleName = maker.deleteCharAt(maker.length() - 1).toString();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getFullName() {
        return this.lastName + " " + this.middleName + " " + this.firstName;
    }
}
