package week07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ15988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer n = Integer.parseInt(br.readLine());

        int[] dp = new int[1_000_001];

        // 세팅
        int div = 1_000_000_009;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for (int i = 4; i <= 1_000_000; i++) {
            dp[i] = ((dp[i - 1] + dp[i - 2])%div + dp[i - 3])%div;
        }

        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < n; i++) {
            int N = Integer.parseInt(br.readLine());

            answer.append(dp[N]).append("\n");
        }

        System.out.print(answer);
    }
}
