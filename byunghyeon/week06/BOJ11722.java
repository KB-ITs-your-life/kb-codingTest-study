package week06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11722 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[N];
        for(int i = N-1; i >=0; i--){
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[N];
        dp[0] = 1;
        // [10 20 20 10 30 10]  작은게 큰 것 안에 간다고 먹는다고 생각
        for(int i = 1; i < N; i++){
            int num = numbers[i];
            for(int j = i-1; j >= 0; j--){
                if(numbers[j] < num){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }else{
                    dp[i] = Math.max(dp[i], 1);
                }
            }
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());

    }
}

