package week05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1449 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int l = Integer.parseInt(input[1]);

        String[] input1 = br.readLine().split(" ");
        int[] pipes = new int[n];
        for (int i = 0; i < n; i++) {
            pipes[i] = Integer.parseInt(input1[i]);
        }
        Arrays.sort(pipes);

        int start = pipes[0];
        int cnt = 0;
        for (int pipe : pipes) {
            if (pipe - start + 1 > l) {
                cnt++;
                start = pipe;
            }
        }
        System.out.println(cnt + 1);
    }
}
