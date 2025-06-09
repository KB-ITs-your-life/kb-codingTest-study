import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Number_12789 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(bufferedReader.readLine());
        int[] students = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        boolean result = true;

        Stack<Integer> stack = new Stack<>();
        int sequence = 1;
        for(int i = 0; i < count; ++i) {
            if(students[i] == sequence) {
                sequence++;
            }
            else {
                stack.push(students[i]);
            }
            while (!stack.isEmpty() && stack.peek() == sequence) {
                stack.pop();
                sequence++;
            }
        }

        if(!stack.isEmpty()) {
            int number = stack.pop();
            int size = stack.size();
            for(int i = 0; i < size; ++i) {
                if(number + 1 == stack.peek()) {
                    number = stack.pop();
                }
                else {
                    result = false;
                    break;
                }
            }
        }

        if(result) {
            System.out.println("Nice");
        } else {
            System.out.println("Sad");
        }


    }
}
