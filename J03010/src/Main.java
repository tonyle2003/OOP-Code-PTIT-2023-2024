import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static int test;
    private static String name;
    private static List<String> list;
    private static List<String> emails = new ArrayList<>();

    public static void main(String[] args) {
        test = scanner.nextInt();
        scanner.nextLine();
        while (test > 0) {
            test--;
            name = scanner.nextLine();
            name = name.toLowerCase();
            String[] splitter = name.split(" ");
            list = new LinkedList<>();
            for (int i = 0; i < splitter.length; i++) {
                if (splitter[i].equals("") == false) {
                    list.add(splitter[i]);
                }
            }
            getEmails();
        }
        printEmails();
    }

    private static void printEmails() {
        for (int i = 0; i < emails.size(); i++) {
            int count = 2;
            for (int j = i + 1; j < emails.size(); j++) {
                if (emails.get(i).equals(emails.get(j))) {
                    emails.set(j, emails.get(j) + count);
                    count++;
                }
            }
        }
        emails.forEach(e -> {
            System.out.println(e + "@ptit.edu.vn");
        });
    }

    private static void getEmails() {
        StringBuilder stringBuilder = new StringBuilder(list.get(list.size() - 1));
        int index = 0;
        while (index != list.size() - 1) {
            stringBuilder.append(list.get(index).charAt(0));
            index++;
        }
        emails.add(stringBuilder.toString());
    }
}
