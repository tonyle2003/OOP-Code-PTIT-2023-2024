import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    static final String FILE_NAME = "MATHANG.in";
    static int n;
    static Set<Product> products = new TreeSet<>(new Comparator<Product>() {
        @Override
        public int compare(Product product1, Product product2) {
            return Double.compare(product2.getProfit(), product1.getProfit());
        }
    });
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream(FILE_NAME));
        n = Integer.parseInt(scanner.nextLine());
        while (n > 0) {
            n--;
            products.add(new Product(
                scanner.nextLine(), 
                scanner.nextLine(), 
                Double.parseDouble(scanner.nextLine()), 
                Double.parseDouble(scanner.nextLine())
            ));
        }
        products.forEach(e -> System.out.println(e));
    }   
}

class Product {

    private static final String HIDDEN_STRING = "MH";
    private static int hiddenNumber = 0;
    private String id;
    private String name;
    private String group;
    private double priceIn;
    private double priceOut;

    public Product(String name, String group, double priceIn, double priceOut) {
        this.id = makeId();
        this.name = name;
        this.group = group;
        this.priceIn = priceIn;
        this.priceOut = priceOut;
    }

    private String makeId() {
        hiddenNumber++;
        if (hiddenNumber < 10) {
            return HIDDEN_STRING + "0" + hiddenNumber;
        } else {
            return HIDDEN_STRING + hiddenNumber;
        }
    }

    public double getProfit() {
        return priceOut - priceIn;
    }

    @Override
    public String toString() {
        
        return String.format("%s %s %s %.2f", id, name, group, priceOut - priceIn);
    }

}