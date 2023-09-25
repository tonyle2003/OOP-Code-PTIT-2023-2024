import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final String FILE_NAME = "SINHVIEN.in";
    private static List<Student> students = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream(FILE_NAME));
        int n = Integer.parseInt(scanner.nextLine());
        while (n > 0) {
            n--;
            students.add(new Student(
                    scanner.nextLine(),
                    scanner.nextLine(),
                    scanner.nextLine(),
                    scanner.nextLine()));
        }

        students.sort((a, b) -> {
            if (a.getFirstName().equals(b.getFirstName())) {
                if (a.getLastName().equals(b.getLastName())) {
                    if (a.getMiddleName().equals(b.getMiddleName())) {
                        return a.getId().compareTo(b.getId());
                    } else {
                        return a.getMiddleName().compareTo(b.getMiddleName());
                    }
                } else {
                    return a.getLastName().compareTo(b.getLastName());
                }
            } else {
                return a.getFirstName().compareTo(b.getFirstName());
            }
        });

        students.forEach(e -> System.out.println(e));
    }
}

class Student {

    private String id;
    private String lastName;
    private String middleName;
    private String firstName;
    private String phoneNumber;
    private String email;

    public Student(String id, String fullName, String phoneNumber, String email) {
        this.id = id;
        String[] words = fullName.trim().split("\\s+");
        this.lastName = words[0];
        this.firstName = words[words.length - 1];
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 1; i < words.length - 1; i++) {
            stringBuffer.append(words[i] + " ");
        }
        this.middleName = stringBuffer.deleteCharAt(stringBuffer.length() - 1).toString();
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return this.lastName + " " + this.middleName + " " + this.firstName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return this.id + " " + this.getFullName() + " " + this.phoneNumber + " " + this.email;
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

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}