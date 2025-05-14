import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Number_1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");
        int K = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);

        long[] trees = new long[K];
        long max = 0;
        for(int i = 0; i < K; ++i) {
            int lanLength = Integer.parseInt(bufferedReader.readLine());
            trees[i] = lanLength;
            if(max < trees[i]) {
                max = trees[i];
            }
        }

        long left = 1;
        long right = max;
        long result = 0;

        while(left <= right) {
            long sum = 0;
            long mid = (left + right) / 2;

            for(long tree : trees) {
                sum += tree / mid;
            }

            if(sum < N) {
                right = mid - 1;
            }
            else {
                result = mid;
                left = mid + 1;
            }
        }
        System.out.println(result);
    }
}
