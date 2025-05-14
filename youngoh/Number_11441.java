import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Number_11441 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(bufferedReader.readLine());
        int[] inputNumber = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] sum = new int[size + 1];
        for(int i = 1; i <= size; ++i) {
            sum[i] = sum[i - 1] + inputNumber[i - 1];
        }

        StringBuilder result = new StringBuilder();

        int tryCount = Integer.parseInt(bufferedReader.readLine());
        for(int i = 0; i < tryCount; ++i) {
            String[] input = bufferedReader.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            result.append(sum[end] - sum[start - 1]).append('\n');
        }

        System.out.println(result);
    }
}
