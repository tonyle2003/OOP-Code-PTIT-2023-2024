import java.util.Scanner;

public class Main {
    
    private static Scanner scanner = new Scanner(System.in);
    private static int test;
    private static String name;
    public static void main(String[] args) {
        test = scanner.nextInt();
        scanner.nextLine();
        while (test > 0) {
            name = scanner.nextLine().trim().toLowerCase();
            String result = "";
            String[] splits = name.split(" ");
            for (int i = 1; i < splits.length; i++) {
                if (!splits[i].equals("")) {
                    result += splits[i].substring(0, 1).toUpperCase() +
                              splits[i].substring(1, splits[i].length()) + " ";
                }
            }
            System.out.print(result.trim() + ", " + splits[0].toUpperCase());
            System.out.println();
            test--;
        }
    }
}
