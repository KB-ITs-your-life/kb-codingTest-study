package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_11286 {
    static class Number{
        int value;
        int absValue;
        public Number(int value){
            this.value=value;
            this.absValue=Math.abs(value);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        PriorityQueue<Number> absHeap=new PriorityQueue<>((a,b)->{
            if(a.absValue!=b.absValue){
                return a.absValue-b.absValue;
            }
            return a.value-b.value;
        });
        for(int i=0;i<n;i++){
            int now=Integer.parseInt(br.readLine());
            if(now==0){
                if(absHeap.isEmpty()){
                    System.out.println(0);
                } else{
                    System.out.println(absHeap.poll().value);
                }
            }else {
                absHeap.add(new Number(now));
            }

        }

    }
}
