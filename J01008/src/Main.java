import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static int test;
    private static List<Pair<Integer, Integer>> result;
    public static void main(String[] args) {
        test = scanner.nextInt();
        for (int i = 1; i <= test; i++) {
            result = getList(scanner.nextInt());
            System.out.print("Test " + i + ": ");
            result.forEach(
                e -> {
                    System.out.print(e.getKey() + "(" + e.getValue() + ") ");
                }
            );
            System.out.println();
        }
    }

    private static List<Pair<Integer, Integer>> getList(int number) {
        int current = 2;
        List<Pair<Integer, Integer>> list = new ArrayList<>();
        while (number != 1) {
            if (number % current == 0) {
                number /= current;
                Pair<Integer, Integer> temp = new Pair<>(current, 1);
                if (list.contains(temp)) {
                    list.set(
                        list.indexOf(temp), 
                        new Pair<Integer, Integer>(current, list.get(list.indexOf(temp)).getValue() + 1)
                    );
                } else {
                    list.add(temp);
                }
            } else {
                current++;
            }
        }
        return list;
    }
}

class Pair<T extends Object, U extends Object> {

    private T key;
    private U value;

    public Pair() {
    }

    public Pair(T key) {
        this.key = key;
    }

    public Pair(T key, U value) {
        this.key = key;
        this.value = value;
    }

    public T getKey() {
        return key;
    }

    public U getValue() {
        return value;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public void setValue(U value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Pair)) {
            return false;
        }
        
        return ((Pair<?, ?>)obj).key.equals(this.key);
    }
}