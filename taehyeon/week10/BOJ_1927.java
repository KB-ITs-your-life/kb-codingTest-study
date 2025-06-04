package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        PriorityQueue<Integer> heap=new PriorityQueue<>();
        for(int i=0;i<n;i++){
            int now=Integer.parseInt(br.readLine());
            if(now==0){
                if(heap.isEmpty()){
                    System.out.println(0);
                } else{
                    System.out.println(heap.poll());
                }

            }
            else{
                heap.add(now);
            }
        }
    }
}
