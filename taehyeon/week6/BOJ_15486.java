package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_15486 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] time=new int[n+1];
        int[] cost=new int[n+1];
        int[] dp=new int[n+3];
        int currTime;


        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            time[i]=Integer.parseInt(st.nextToken());
            cost[i]=Integer.parseInt(st.nextToken());
        }

        // 1일의 상담을 했을 때 1,4,5,7만 가능
        // 2일의 상담하면 2,7만 가능
        // 만약 마지막 상담의 소요 기간이 1일 이상이면 불가.

        // dp[i]와 cost[i] 중에 큰 것 선택.
        // while문을 통해 i를 계속 업데이트 해가면서



        int max=0;

        for(int i=1;i<=n;i++){
            currTime=time[i];
            if(i+time[currTime]<=n){      // 현재 날짜 + 소요 날짜 <=n
                System.out.println(i+currTime);
                dp[i]=Math.max(dp[i+currTime],dp[i]+cost[i+currTime]+cost[i]);
            }
            System.out.println(i+"번쨰 : "+dp[i]);
            max=Math.max(max,dp[i]);

        }
        System.out.println(max);


    }
}
