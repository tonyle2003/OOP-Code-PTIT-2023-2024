import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        // Scanner scanner = new Scanner(new FileInputStream("test.txt"));
        while (scanner.hasNextLine()) {
            String[] temp = scanner.nextLine().trim().toLowerCase().split("\\s+");
            boolean isEndLine = false;
            temp[0] = temp[0].substring(0, 1).toUpperCase() + temp[0].substring(1);
            for (int i = 0; i < temp.length; i++) {
                if (temp[i].contains(".") || temp[i].contains("?") || temp[i].contains("!")) {
                    System.out.print(temp[i].substring(0, temp[i].length() - 1) + "\n");
                    isEndLine = true;
                } else {
                    if (isEndLine) {
                        System.out.print(temp[i].substring(0, 1).toUpperCase() + temp[i].substring(1) + " ");
                        isEndLine = false;
                    } else {
                        System.out.print(temp[i] + " ");
                    }
                }
            }
        }
    }
}
