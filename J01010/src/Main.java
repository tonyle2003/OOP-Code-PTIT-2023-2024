import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static int test;
    private static Scanner scanner = new Scanner(System.in);
    private static List<String> chars;

    public static void main(String[] args) {
        test = scanner.nextInt();
        while (test > 0) {
            test--;
            try {
                chars = toList();
                splitHalf();
                chars.forEach(e -> {
                    System.out.print(e);
                });
                System.out.println();
            } catch (SplitException splitException) {
                System.out.println(splitException.getMessage());
            }
        }

    }

    private static void splitHalf() throws SplitException {
        for (int i = 0; i < chars.size(); i++) {
            switch (chars.get(i)) {
                case "0":
                case "8":
                case "9":
                    chars.set(i, "0");
                    break;
                case "1":
                    break;
                default:
                    throw new SplitException("INVALID");
            }
        }
        int index = 0;
        while (index != chars.size()) {
            if (chars.get(index) == "0") {
                chars.remove(index);
            } else {
                break;
            }
        }
        if (chars.size() == 0) {
            throw new SplitException("INVALID");
        }
    }

    private static List<String> toList() {
        List<String> list = new LinkedList<>();
        String[] chars = scanner.next().split("");
        for (int i = 0; i < chars.length; i++) {
            list.add(chars[i]);
        }
        return list;
    }
}

class SplitException extends RuntimeException {

    public SplitException(String message) {
        super(message);
    }
}