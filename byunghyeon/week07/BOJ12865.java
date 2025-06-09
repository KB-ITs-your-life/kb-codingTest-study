package week07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 물품 수
        int K = Integer.parseInt(st.nextToken()); // 버틸 수 있는 무게

        // 입력
        int[][] backpack = new int[N+1][2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            backpack[i][0] = Integer.parseInt(st.nextToken()); // 무게
            backpack[i][1] = Integer.parseInt(st.nextToken()); // 가치
        }

        // dp
        // 무게는 K까지, 가치는 최대
        int[][] dp = new int[N+1][K+1];
        for(int i = 1; i <= N; i++){
            int W = backpack[i][0];
            int V = backpack[i][1];
            for(int j = 1; j <= K; j++){
                if(j-W < 0){ dp[i][j] = dp[i-1][j]; continue;}

                dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-W] + V); // 이전꺼를 이용
            }
        }

        System.out.println(dp[N][K]);
    }
}
