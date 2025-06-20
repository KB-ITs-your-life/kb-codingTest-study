package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < N; i++){
            pq.add(Integer.parseInt(br.readLine()));
        }

        int total = 0;
        while(!(pq.size() <= 1)){
            Integer i1 = pq.poll();
            Integer i2 = pq.poll();
            int sum = i1 + i2;
            pq.add(sum);
            total+=sum;
        }

        System.out.println(total);

    }
}
