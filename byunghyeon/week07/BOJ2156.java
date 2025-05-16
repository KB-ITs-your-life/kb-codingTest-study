package week07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2156 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] wines = new int[n+1];
        for(int i = 1; i <= n; i++){
            wines[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[n+1];
        if(n == 1){
            System.out.println(wines[1]);
            return;
        }else if(n == 2){
            System.out.println(wines[1] + wines[2]);
            return;
        }

        dp[1] = wines[1];
        dp[2] = wines[1] + wines[2];
        dp[3] = Math.max(wines[1], wines[2]) + wines[3];

        for(int i = 4; i <= n; i++){
            dp[i] = Math.max(Math.max(dp[i-3] + wines[i-1], dp[i-2]),dp[i-4] + wines[i-1]) + wines[i];
        }

        for (int wine : wines) {
            System.out.print(wine + " ");
        }
        System.out.println();

        for (int i : dp) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println(Math.max(dp[n], dp[n-1]));
    }
}
