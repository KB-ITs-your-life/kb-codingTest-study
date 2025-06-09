package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] wine=new int[n+2];
        for(int i=1;i<=n;i++){
            wine[i]=Integer.parseInt(br.readLine());
        }
        int[] dp =new int[n+2];
        int max=0;


        dp[1]=wine[1];
        dp[2]=wine[2]+wine[1];

        // i-2번째 와인 최대로 마실 경우 + 지금 와인 마심 vs 지금 와인 안먹는 경우의 수.
        // vs i-1잔 + i잔 + dp[i-3]
        // dp[i]= i번째 잔일 때 최대로 많이 마신 것.

        /*  핵심 아이디어
        3가지 경우의 수를 모두 고려하여 최댓값 선택:

        이전 두 잔 건너뛰고 현재-1 & 현재 잔 마심
        → dp[i-3] + wine[i-1] + wine[i]

        직전 잔 건너뛰고 현재 잔 마심
        → dp[i-2] + wine[i]

        현재 잔을 마시지 않음
        → dp[i-1]

        */
        for(int i=3;i<=n;i++){
            dp[i]=Math.max(dp[i-3]+wine[i-1]+wine[i],Math.max(dp[i-2]+wine[i],dp[i-1]));
        }
        System.out.println(dp[n]);

        // 연속 3잔은 못먹는다
        // i번째 잔을 먹으려면

        // dp[i-2] + wine[i] 와 wine[i-1]+wine[i]+dp[i-3]


    }
}
