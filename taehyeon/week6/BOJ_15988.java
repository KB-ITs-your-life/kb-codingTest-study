package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15988 {
    static long[]dp;

    static long sum(int n){
        dp=new long[n+3];
        dp[1]=1;
        dp[2]=2;
        dp[3]=4;

        for(int i=4;i<=n;i++){
            dp[i]=(dp[i-1]+dp[i-2]+dp[i-3])%1000000009;
        }



        return dp[n];

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            int n = Integer.parseInt(br.readLine());
            System.out.println(sum(n));
        }
    }
}
