package week07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ11057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[1001][10];
        Arrays.fill(dp[1], 1);
        for(int i = 2; i <= N; i++){
            dp[i][0] = 1;
            for(int j = 1; j < 10; j++){
                dp[i][j] = (dp[i-1][j] + dp[i][j-1])%10007;
            }
        }

        int answer = 0;
        for(int i = 0; i < 10; i++){
            answer = (answer + dp[N][i])%10007;
        }
        System.out.println(answer);
    }
}
