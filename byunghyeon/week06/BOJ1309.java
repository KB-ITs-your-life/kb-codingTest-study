package week06;

/*
*
* 소문제
* 소문제 나누는 변수
* 점화식
* 초기값
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1309 {
    static int N; // 사자 배치 x도 하나도 가정
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 우리 크기

        long[] dp = new long[N+1];
        dp[0] = 1;
        dp[1] = 3;
        for(int i = 2; i <= N; i++){
            dp[i] = ((2*dp[i-1])%9901 + dp[i-2])%9901;
            //dp[i] = 2*dp[i-1] + dp[i-2];
        }
        System.out.println(dp[N]);

    }
}