import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    static final String FILE_NAME = "KHACHHANG.in";
    static int n;
    static Set<Customer> customers = new TreeSet<>(new Comparator<Customer>() {

        @Override
        public int compare(Customer customer1, Customer customer2) {
            return Integer.compare(customer2.getPrice(), customer1.getPrice());
        }

    });

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream(FILE_NAME));
        n = Integer.parseInt(scanner.nextLine());
        while (n > 0) {
            n--;
            customers.add(new Customer(
                    scanner.nextLine(),
                    scanner.nextLine(),
                    scanner.nextLine(),
                    scanner.nextLine(),
                    Integer.parseInt(scanner.nextLine())));
        }
        customers.forEach(e -> System.out.println(e));
    }
}

enum Price {

    ONE(1, 25), TWO(2, 34), THREE(3, 50), FOUR(4, 80);

    private int price;
    private int number;

    Price(int number, int price) {
        this.number = number;
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }

    public int getNumber() {
        return this.number;
    }
}

class Customer {

    private static final String HIDDEN_STRING = "KH";
    private static int hiddenNumber = 0;
    private String id;
    private String name;
    private String number;
    private String dayIn;
    private String dayOut;
    private int payMore;

    public Customer(String name, String number, String dayIn, String dayOut, int payMore) {
        this.id = makeId();
        this.name = formatName(name);
        this.number = number.trim();
        this.dayIn = formatDate(dayIn.trim());
        this.dayOut = formatDate(dayOut.trim());
        this.payMore = payMore;
    }

    public int getPrice() {
        int temp = 0;
        for (Price price : Price.values()) {
            if (Integer.parseInt(number.charAt(0) + "") == price.getNumber()) {
                temp = price.getPrice();
            }
        }
        int days = getStayDay();
        return temp * days + payMore;
    }

    public int getStayDay() {
        String[] date1 = dayIn.split("/");
        String[] date2 = dayOut.split("/");

        long days = LocalDate
                .of(Integer.parseInt(date1[2]), Integer.parseInt(date1[1]), Integer.parseInt(date1[0]))
                .until(
                    LocalDate.of(Integer.parseInt(date2[2]), Integer.parseInt(date2[1]), Integer.parseInt(date2[0])),
                    ChronoUnit.DAYS
                );

        return (int) days + 1;
    }

    private String formatDate(String date) {
        String[] numbers = date.split("/");
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i].length() == 1) {
                numbers[i] = "0" + numbers[i];
            }
        }
        return numbers[0] + "/" + numbers[1] + "/" + numbers[2];
    }

    private String makeId() {
        hiddenNumber++;
        if (hiddenNumber < 10) {
            return HIDDEN_STRING + "0" + hiddenNumber;
        } else {
            return HIDDEN_STRING + hiddenNumber;
        }
    }

    private String formatName(String name) {
        String[] words = name.trim().split("\\s+");
        StringBuilder stringBuilder = new StringBuilder("");
        for (String word : words) {
            stringBuilder.append(
                    word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase() + " ");
        }
        return stringBuilder.toString().trim();
    }

    @Override
    public String toString() {
        return id + " " + name + " " + number + " " + getStayDay() + " " + getPrice();
    }

}