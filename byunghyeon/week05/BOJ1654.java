package week05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1654 {
    static int N, K;
    static long[] lines;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // K와 N 입력
        K = Integer.parseInt(st.nextToken()); // 랜선 개수
        N = Integer.parseInt(st.nextToken()); // 원하는 개수

        // 랜선들 입력
        lines = new long[K];
        for(int i = 0; i < K; i++){
            int line = Integer.parseInt(br.readLine());
            lines[i] = line;
        }

        int count;
        long start = 1;
        long end = Arrays.stream(lines).max().getAsLong();
        long mid;
        long answer = -1;
        while(start <= end) {
            count = 0;
            mid = (start + end) / 2;

            for (int i = 0; i < K; i++) {
                count += lines[i] / mid;
            }

            // 범위를 >=로 한 것이 핵심
            if(count >= N){ // 목표 개수보다 크다 => 더 크게
                answer = mid;
                start = mid+1;
            }else if(count < N){ // 목표 개수보다 작다 => 더 잘게
                end = mid-1;
            }
        }
        System.out.println(answer);
    }
}
