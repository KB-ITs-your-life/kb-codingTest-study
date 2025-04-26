package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_9095 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb=new StringBuilder();

        int k = Integer.parseInt(st.nextToken());
        /*
             N을 출력할 수 있는 모든 경우의 수를 다해본다?
             거꾸로 생각해보자
             3을 몇번 뺄수 있는지?
             3하나에 111,12,21,3 ->4개
             2하나에 11,2 ->2개
             1하나에 1개

            n=4라면 -> 왼쪽 수 만 필요
            f(3) + f(1) : 4
            f(2) + f(2) : 2
            f(1) + f(3) : 1

            f(n)=f(n-1) + f(n-2) + f(n-3)
         */
        int[] fn=new int[11];
        fn[1]=1;
        fn[2]=2;
        fn[3]=4;

        for(int i=4;i<11;i++){
            fn[i]=fn[i-1]+fn[i-2]+fn[i-3];
        }
        for(int i=0;i<k;i++){
            int n=Integer.parseInt(br.readLine());
            System.out.println(fn[n]);
        }





    }
}
