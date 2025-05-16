package week07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[][] rgbs = new int[N+1][3+1]; //[집개수][색깔개수]
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= 3; j++){
                rgbs[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[N+1][3+1];
        dp[1][1] = rgbs[1][1];
        dp[1][2] = rgbs[1][2];
        dp[1][3] = rgbs[1][3];

        for(int i = 2; i <= N; i++){
            dp[i][1] = Math.min(dp[i-1][2], dp[i-1][3]) + rgbs[i][1];
            dp[i][2] = Math.min(dp[i-1][1], dp[i-1][3]) + rgbs[i][2];
            dp[i][3] = Math.min(dp[i-1][1], dp[i-1][2]) + rgbs[i][3];
        }

        int answer = Math.min(Math.min(dp[N][1], dp[N][2]), dp[N][3]);
        System.out.println(answer);
    }
}
