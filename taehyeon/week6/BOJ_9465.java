package week6;

import java.io.*;
import java.util.*;

/* 1. DP 핵심 개념
중복 부분 문제: 동일한 계산이 반복되는 문제 (예: 피보나치 수열)
최적 부분 구조: 큰 문제의 최적해가 작은 문제의 최적해로 구성되는 성질 (예: 최단 경로)

 * */

public class BOJ_9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] sticker;
        int[][] dp;


        int T=Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            //스티커 입력받기
            int n=Integer.parseInt(br.readLine());
            sticker=new int[2][n];
            dp=new int[2][n+3];


            st=new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++){
                sticker[0][i]=Integer.parseInt(st.nextToken());
            }

            st=new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++){
                sticker[1][i]=Integer.parseInt(st.nextToken());
            }
            // 기저 조건
            dp[0][0]=sticker[0][0];
            dp[1][0]=sticker[1][0];

            dp[0][1]=sticker[1][0]+sticker[0][1];
            dp[1][1]=sticker[0][0]+sticker[1][1];


            dp[0][1]=sticker[1][0]+sticker[0][1];
            dp[1][1]=sticker[0][0]+sticker[1][1];

            for(int i=2;i<n;i++){
                dp[0][i]=Math.max(dp[1][i-2], dp[1][i-1])+sticker[0][i];
                dp[1][i]=Math.max(dp[0][i-2], dp[0][i-1])+sticker[1][i];
            }

            System.out.println(Math.max(dp[0][n-1],dp[1][n-1]));

            /* 풀이 : n=i

                - [0][i] 일 때 dp[1][i-2]와 dp[1][i-1]
                - [1][i] 일 때 dp[0][i-2]와 dp[0][i-1]

            */

        }

    }
}
