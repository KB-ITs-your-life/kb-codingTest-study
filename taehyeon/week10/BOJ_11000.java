package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
8
1 8
9 16
3 7
8 10
10 14
5 6
6 11
11 12
3

4
1 3
2 4
3 5
4 6
2

7
0 7
32 42
32 40
45 46
0 8
24 32
9 19
2

*/

public class BOJ_11000 {
    static class Lec{
        int start;
        int end;
        public Lec(int start, int end){
            this.start = start;
            this.end = end;
        }


    }


    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        StringTokenizer st;
        // 최대 힙 정렬
        PriorityQueue<Lec> pq=new PriorityQueue<>((a,b)->a.end-b.end);
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            pq.add(new Lec(start,end));

        }
        for(Lec l:pq){
            System.out.println(l.start+","+l.end);
        }

        // pq에서 뽑은 최솟값이 stack의 최대 값보다 큰지 판단.

//        Stack<Integer> ls=new Stack<>();
//        ls.add(pq.poll().end);
//        while(!pq.isEmpty()){
//            System.out.println(ls);
//            Lec tmpLecture=pq.poll();
//            int recentEnd=ls.getLast();
//            if(tmpLecture.start<recentEnd){
//                ls.add(tmpLecture.end);
//
//            } else{
//                ls.pop();
//                ls.add(tmpLecture.end);
//            }
//        }
//        System.out.println(ls);





    }

}
