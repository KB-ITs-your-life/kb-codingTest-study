package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;



public class BOJ_15903 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            pq.add(Long.parseLong(st.nextToken()));

        }
        //가장 작은 값 두개를 뺴서 더한 뒤 다시 넣으면 재 정렬 되며 가장 작은 값을 구할 수 있따.
        for(int i = 0; i < M; i++){
            long num1=pq.poll();
            long num2=pq.poll();
            pq.add(num1+num2);
            pq.add(num1+num2);

//            System.out.println(pq);
        }
        long sum=0;
        for(int i = 0; i < N; i++){
            sum+=pq.poll();
        }
        System.out.println(sum);

    }
}
