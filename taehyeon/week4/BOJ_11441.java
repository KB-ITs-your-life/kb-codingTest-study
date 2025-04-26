package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
*  이건 또 어떻게 푸냐
*  그냥 반복문으로 하면 안되나?
*  일단 HashMap으로 index,value넣어서 index로 접근해 보자
*  이중 반복하면 바로 시간초과네
*
*  누적합? 이거 아이디어를 어떻게 접근해야하지.
*  x,y 범위를 입력받으면 내가 합을 하는게 아니라 O(1)로 알아서 나와야한다. 어케하는데
*  입력받을때 더해서 넣으면
*  numbers[3] 은 0,1,2,3을 더한것.
*  그러면 1,3을 구하라그러면 numbers[3]-num[1]하면 되는 거 아닐까?
*  123을 구하는거니까
*
*
* */



public class BOJ_11441 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb=new StringBuilder();

        int N = Integer.parseInt(st.nextToken());

        int [] numbers=new int[N+1];
        st = new StringTokenizer(br.readLine());

        numbers[0]=0;
        int sum=0;
        for(int i = 1; i <= N; i++){
            sum+=Integer.parseInt(st.nextToken());
            numbers[i]=sum;
        }

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());

        int need=0;
        for(int k = 0; k < M; k++){


            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            need=numbers[y]-numbers[x-1];

            sb.append(need).append("\n");
        }
        System.out.print(sb);




    }
}
