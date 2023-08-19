import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {    
        solve(scanner.next());
    }   

    static void solve(String string) {
        List<String> listChar = new ArrayList<>(Arrays.asList(string.split("")));
        while (true) {
            boolean check = false;
            for (int i = 0; i < listChar.size() - 1; i++) {
                if (listChar.get(i).equals(listChar.get(i + 1))) {
                    listChar.remove(i + 1);
                    listChar.remove(i);
                    check = true;
                    break;
                }
            }
            if (check == false) {
                break;
            }
        }
        if (listChar.size() == 0) {
            System.out.println("Empty String");
        } else {
            listChar.forEach(e -> System.out.print(e));
            System.out.println();
        }
    }
}
