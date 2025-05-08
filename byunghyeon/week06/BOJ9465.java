package week06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ9465 {
    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        int n;
        StringTokenizer st;
        for(int i = 0; i < T; i++) {
            // 스티커 열 개수
            n = Integer.parseInt(br.readLine());

            // 스티커 입력
            int[][] stickers = new int[2][n];
            for (int j = 0; j < 2; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    stickers[j][k] = Integer.parseInt(st.nextToken());
                }
            }


            int[][] dp = new int[2][n];
            int answer = -1;
            dp[0][0] = stickers[0][0];
            dp[1][0] = stickers[1][0];
            if(n != 1) {
                dp[0][1] = dp[1][0] + stickers[0][1];
                dp[1][1] = dp[0][0] + stickers[1][1];

                for(int j = 2; j < n; j++){
                    dp[0][j] = Math.max(dp[1][j-1], Math.max(dp[0][j-2], dp[1][j-2])) + stickers[0][j];
                    dp[1][j] = Math.max(dp[0][j-1], Math.max(dp[1][j-2], dp[0][j-2])) + stickers[1][j];
                }
            }

            answer = Math.max(dp[0][n-1], dp[1][n-1]);

            System.out.println(answer);
        }
    }
}
