package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11057 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] dp= new long[n+3][10];

        for(int i=0;i<10;i++){
            dp[0][i]=1;
        }

         // 10 9 8 7 6 5 4 3 2 1
        // 55 45 36 28 21 15 10 6 3 1
        //dp[4]는 220 + (220-55)+(220-55-45)+

        // dp[i] += dp[i-1] - count

        long sum;

        for(int i=1;i<=n;i++){
            sum=0;
            for(int j=9;j>=0;j--){
                sum+=dp[i-1][j];
                dp[i][j]=sum%10007;
            }



//            System.out.println("dp "+i+"번쨰는 : "+ dp[i][0]);
        }

        System.out.println(dp[n][0]%10007);






    }
}
