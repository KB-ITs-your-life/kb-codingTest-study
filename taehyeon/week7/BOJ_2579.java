package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2579 {
    static int[] stair;
    static long[] dp;

    // HINT
    // 한 칸만에 찾았을 때랑 두 칸에 찾았을 때 최댓값을 따로 하라고?
    // n번째 계단을 1계단으로 올라갔을때 최댓값,
    // n번째 계단을 2계단으로 올라갔을때 최댓값 2가지 경우의 최댓값을 구해야 됩니다.

    // N번째 계단을 최대값으로 올라가려면?
    // 1계단으로 올라갔을 때랑 2계단으로 올라갔을때 중 최대값을 비교?
    // ex - n=4 : 4번째를 확인할 때
    // 1. 1번 계단 포함경우
    // 1-1. 2번 밟을 경우 dp[1]+stair[2]
    // 1-2. 3번 밟을 경우 dp[1]+stair[3]
    // 2. 1번 계단 안 밟을 경우
    // 2-1. 2번 밟을 경우 dp[2]
    // 2-2. 3번 밟을 경우 stair[3] + dp[0]?
    // ??

    /* i번째 확인할 경우
        - i-1번 계단 밟을 경우 : dp[i]= dp[i-2] + stair[i-1]
        - i-2번 계단 밟을 경우
            - i-3 밟을때 : dp[i]= dp[i-3] + stair[i-2]
            -


    */


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        stair=new int[n+2];
        dp=new long[n+3];

        for(int i=1;i<=n;i++){
            stair[i]=Integer.parseInt(br.readLine());
        }
        dp[0]=0;
        dp[1]=stair[1]+dp[0];
        dp[2]=Math.max(dp[0]+stair[2],dp[1]+stair[2]);


//        for(int i=3;i<=n;i++){
//            dp[i]=Math.max(dp[i-3]+stair[i]+stair[i-2],dp[i-2]+stair[i]);
//        }
        for(int i=3;i<=n;i++){
            dp[i]=Math.max(dp[i-3]+stair[i-1],dp[i-2])+stair[i];
        }
//        for(int i=3;i<=n;i++){
//            dp[i]=Math.max(Math.max(dp[i-3]+stair[i]+stair[i-2],dp[i-3]+stair[i]+stair[i-1]),dp[i-2]+stair[i]);
//        }

//        for(int i=0;i<=n;i++){
//            System.out.println("지금은 "+i+"번째 : "+dp[i]);
//        }
        System.out.println(dp[n]);



    }
}
