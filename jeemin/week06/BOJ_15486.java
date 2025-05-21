package week06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15486 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] counsel = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            counsel[i][0] = Integer.parseInt(input[0]);
            counsel[i][1] = Integer.parseInt(input[1]);
        }
        int[] dp = new int[n + 1];
        int max = 0;
        int w = 0;
        for (int j = 0; j < n; ++j) {
            int days = counsel[j][0];
            int price = counsel[j][1];

            w = Math.max(w, dp[j]);

            if (j + days <= n) {
                dp[j + days] = Math.max(w + price, dp[j + days]);
                if (dp[j + days] > max) {
                    max = dp[j + days];
                }
            }
        }

        System.out.println(max);
    }
}