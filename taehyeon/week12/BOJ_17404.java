package week12;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_17404 {


    public static void main(String[] args)throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] house=new int[n+1][3];




        for(int t=1;t<=n;t++){
            st=new StringTokenizer(br.readLine());
            int r=Integer.parseInt(st.nextToken()); // 0
            int g=Integer.parseInt(st.nextToken()); // 1
            int b=Integer.parseInt(st.nextToken()); // 2

            house[t][0]=r;
            house[t][1]=g;
            house[t][2]=b;
        }

        int[]dp=new int[n+2];
        dp[1]=Math.min(house[0][0],Math.min(house[0][1],house[0][2]));






    }
}
