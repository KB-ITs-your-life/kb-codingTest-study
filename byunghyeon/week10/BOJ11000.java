package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ11000{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Time[] times = new Time[N];
        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            times[i] = new Time(start, end);
        }
        Arrays.sort(times);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(times[0].end);
        // 강의실 배정
        for (int i = 1; i < times.length; i++) {
            Time time = times[i];
            if(time.start >= pq.peek()){
                pq.poll();
            }
            pq.add(time.end);
        }

        System.out.println(pq.size());
    }

    static class Time implements Comparable<Time>{
        int start;
        int end;
        public Time(int start, int end){
            this.start = start;
            this.end = end;
        }
        @Override
        public int compareTo(Time o) {
            return Integer.compare(this.start, o.start); // 시작 시간 기준 오름차순
            // 음수일수록 우선순위가 높다.
            /*
            * 전자가 크면 +
            * 0이면 같음
            * 후자가 크면 -
            * */
        }

    }
}