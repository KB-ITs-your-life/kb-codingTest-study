import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Number_28278 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(bufferedReader.readLine());
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < count; ++i) {
            String input = bufferedReader.readLine();
            operate(stack, input);
        }
    }

    private static void operate(Stack<Integer> stack, String input) {
        if(input.length() > 1) {
            stack.push(Integer.parseInt(input.split(" ")[1]));
            return;
        }
        if(input.equals("2")) {
            if(stack.isEmpty()) {
                System.out.println("-1");
                return;
            }
            System.out.println(stack.pop());
            return;
        }
        if(input.equals("3")) {
            System.out.println(stack.size());
            return;
        }
        if(input.equals("4")) {
            if(stack.isEmpty()) {
                System.out.println("1");
                return;
            }
            System.out.println("0");
        }
        if(input.equals("5")) {
            if(stack.isEmpty()) {
                System.out.println("-1");
                return;
            }
            System.out.println(stack.peek());
        }
    }
}
