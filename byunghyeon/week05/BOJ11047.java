package week05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11047 {
    static int N,K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int[] coins = new int[N];
        for(int i = 0; i < N; i++){
            int coin = Integer.parseInt(br.readLine());
            coins[i] = coin;
        }
        int count = 0;
        for(int i = coins.length-1; i >=0; i--){
            int coin = coins[i];
            if(K/coin == 0)
                continue;

            count+=K/coin;
            K -= coin*(K/coin);

        }

        System.out.println(count);

    }
}
