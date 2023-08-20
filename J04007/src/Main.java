import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(new Staff(
            scanner.nextLine(), 
            scanner.nextLine(), 
            scanner.nextLine(), 
            scanner.nextLine(), 
            scanner.nextLine(), 
            scanner.nextLine()
        ));
    }
}

class Staff {
    private final String id = "00001";
    private String fullName;
    private String gender;
    private String dob;
    private String address;
    private String taxCode;
    private String signedDate;

    public Staff(String fullName, String gender, String dob, String address, String taxCode, String signedDate) {
        this.fullName = fullName;
        this.gender = gender;
        this.dob = dob;
        this.address = address;
        this.taxCode = taxCode;
        this.signedDate = signedDate;
    }

    @Override
    public String toString() {
        return String.format(
            "%s %s %s %s %s %s %s", 
            id, fullName, gender, dob, address, taxCode, signedDate
        );
    }
}
