import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int test;
    static Set<Item> listItems = new TreeSet<>();
    public static void main(String[] args) {
        test = scanner.nextInt();
        while (test > 0) {
            scanner.nextLine();
            test--;
            listItems.add(
                new Item(
                    scanner.nextLine(), 
                    scanner.nextLine(), 
                    scanner.nextInt(), 
                    scanner.nextInt()
                )
            );
        }
        listItems.forEach(e -> System.out.println(e));
    }
}

class Item implements Comparable<Item> {
    private static int numberId = 1;
    private String id;
    private String name;
    private String unit;
    private int priceIn;
    private int priceOut;

    public Item(String name, String unit, int priceIn, int priceOut) {
        String temp = "MH";
        for (int i = 0; i < 3 - (numberId + "").length(); i++) {
            temp += "0";
        }
        this.id = temp + numberId;
        this.name = name;
        this.unit = unit;
        this.priceIn = priceIn;
        this.priceOut = priceOut;
        numberId++;
    }

    @Override
    public int compareTo(Item obj) {
        if (this.priceOut - this.priceIn > obj.priceOut - obj.priceIn) {
            return -1;
        } else if (this.priceOut - this.priceIn < obj.priceOut - obj.priceIn) {
            return 1;
        } else {
            return this.id.compareTo(obj.id);
        }
    }

    @Override
    public String toString() {
        return id + " " + name + " " + unit + " " + priceIn + " " + priceOut + " " + (priceOut - priceIn);
    }
}