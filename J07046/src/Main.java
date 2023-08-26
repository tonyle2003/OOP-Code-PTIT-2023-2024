import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    static final String FILE_NAME = "KHACH.in";
    static Set<Customer> customers = new TreeSet<>(Comparator.reverseOrder());

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream(FILE_NAME));
        int n = Integer.parseInt(scanner.nextLine());
        while (n > 0) {
            n--;
            customers.add(new Customer(
                scanner.nextLine(), 
                scanner.nextLine(), 
                scanner.nextLine(), 
                scanner.nextLine()
            ));
        }
        customers.forEach(e -> System.out.println(e));
    }
}

class Customer implements Comparable<Customer> {
    
    private static final String HIDDEN_STRING = "KH";
    private static int hiddenNumber = 0;
    private String id;
    private String fullName;
    private String roomId;
    private LocalDate joinDate;
    private LocalDate leaveDate;
    private int stayDays;

    public Customer(String fullName, String roomId, String joinDate, String leaveDate) {
        this.id = makeId();
        this.fullName = fullName;
        this.roomId = roomId;
        this.joinDate = makeDate(joinDate);
        this.leaveDate = makeDate(leaveDate);
        this.stayDays = makeStayDays();
    }

    private LocalDate makeDate(String date) {
        String[] temp = date.split("/");
        return LocalDate.of(
            Integer.parseInt(temp[2]), 
            Integer.parseInt(temp[1]), 
            Integer.parseInt(temp[0])
        );
    }

    private int makeStayDays() {
        return Period.between(joinDate, leaveDate).getDays();
    }

    private String makeId() {
        hiddenNumber++;
        if (hiddenNumber < 10) {
            return HIDDEN_STRING + "0" + hiddenNumber;
        } else {
            return HIDDEN_STRING + hiddenNumber;
        }
    }

    @Override
    public String toString() {
        return id + " " + fullName + " " + roomId + " " + stayDays;
    }

    @Override
    public int compareTo(Customer other) {
        return Integer.compare(this.stayDays, other.stayDays);
    }
}