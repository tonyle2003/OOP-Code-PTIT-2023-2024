import java.util.Scanner;
import java.util.Stack;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Stack<Character> stack1 = new Stack<>();
    static Stack<Character> stack2 = new Stack<>();
    public static void main(String[] args) {
        String input = scanner.next();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '<') {
                if (stack1.empty() == false) {
                    stack2.push(stack1.pop());
                }
            } else if (input.charAt(i) == '>') {
                if (stack2.empty() == false) {
                    stack1.push(stack2.pop());
                }
            } else if (input.charAt(i) == '-') {
                if (stack1.empty() == false) {
                    stack1.pop();
                }
            } else {
                stack1.push(input.charAt(i));
            }
        }
        while (stack2.empty() == false) {
            stack1.push(stack2.pop());
        }
        for (int i = 0; i < stack1.size(); i++) {
            System.out.print(stack1.get(i));
        }
    }
}
