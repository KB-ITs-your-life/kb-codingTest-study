package week06;

/*
* 소문제 - f(x) = x 가 1로 만들기 위한 최소 연산 횟수
* 소문제를 나누는 변수 : i, 소문제의 정답 dp[i]
* 점화식 - f(x) = min(f(x-1), f(x/2), f(x/3)) + 1
* 초기값 - dp[1] = 0
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1463_DP { // Bottom-up DP
    static int N;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[] dp = new int[1000001];
        dp[1] = 0;

        for(int i = 2; i<= N; i++){
            dp[i] = dp[i-1] + 1;
            if (i % 2 == 0) dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            if (i % 3 == 0) dp[i] = Math.min(dp[i], dp[i / 3] + 1);
        }
        System.out.println(dp[N]);

    }
}
//10,000,000 < 2^24
//int 256 => 1Kb
//int 1024x8192 => 128Mb
//1500만 연산 이내
