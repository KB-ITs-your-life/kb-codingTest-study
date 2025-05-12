package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* DP 조건
 * 1. 겹치는 소문제 : 문제를 작게 나누고 결과를 재사용해서 원하는 결과 도출
 * 2. 최적 부분 구조 : 소문제 최적 결과로 전체 문제의 최적 결과를 낼수 있는가?
 * 소문제의 결과를 저장하고 결과값 도출 조건을 구해둔다.
 * */

public class BOJ_1309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());


        //추가되는 칸을 기준으로 계산한다.
        // 공백 , 왼쪽에 채우기, 오른쪽에 채우기

        long[] dp = new long[N+2];
        dp[0]=1;
        dp[1]=3;
        dp[2]=7;

        /*  n=3 일때
            추가되는 칸 공백 : 7
            왼쪽 채우기 : 5
            오른쪽 채우기 : 5
            dp[3]=17

            n=4
            공백 : 17
            왼쪽 : 12
            오른쪽 : 12
            dp[4]= 41

            : dp[n]=dp[n-1]*2+dp[n-2]
        */
        for(int i=3;i<=N;i++){
            dp[i]=(dp[i-1]*2+dp[i-2])%9901;
        }
        System.out.println(dp[N]);







    }
}
