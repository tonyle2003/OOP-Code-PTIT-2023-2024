import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    static final String FILE_NAME = "SANPHAM.in";
    static int n;
    static Set<Product> products = new TreeSet<>();

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream(FILE_NAME));
        n = Integer.parseInt(scanner.nextLine());
        while (n > 0) {
            n--;
            products.add(new Product(
                scanner.nextLine(), 
                scanner.nextLine(), 
                Integer.parseInt(scanner.nextLine()), 
                Integer.parseInt(scanner.nextLine())
            ));
        }
        products.forEach(e -> System.out.println(e));
    }
}

class Product implements Comparable<Product> {

    private String id;
    private String name;
    private int price;
    private int warrantyPeriod;

    public Product(String id, String name, int price, int warrantyPeriod) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.warrantyPeriod = warrantyPeriod;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + price + " " + warrantyPeriod;
    }

    private int compareId(Product product) {
        return this.id.compareTo(product.id);
    }

    @Override
    public int compareTo(Product product) {
        if (this.price != product.price) {
            return Integer.compare(product.price, this.price);
        }
        return compareId(product);
    }

}