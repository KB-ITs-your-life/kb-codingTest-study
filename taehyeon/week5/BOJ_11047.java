package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int []coin =new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            coin[i]= Integer.parseInt(st.nextToken());

        }

        int res=0;
        for (int i = N-1; i >=0; i--) {
            if(K>=coin[i]){
                res+=K/coin[i];
                K=K%coin[i];
            }


        }
        System.out.println(res);

    }
}