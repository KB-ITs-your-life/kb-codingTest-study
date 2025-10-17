package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;


/*
5
73
18
14
24
13

* */

public class BOJ_1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq=new PriorityQueue<>();

        for(int i=0;i<n;i++){
            pq.add(Integer.parseInt(br.readLine()));
        }

        int sum=0;
        while(pq.size()!=1){
            int a=pq.poll();
            int b=pq.poll();
//            System.out.println(a+b);
            sum+=a+b;
            pq.add(a+b);


        }
        System.out.println(sum);



    }
}

















