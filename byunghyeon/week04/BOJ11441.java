package week04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11441 {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N+1];
        arr[0] = 0;
        arr[1] = Integer.parseInt(st.nextToken());
        for(int i = 2; i < N+1; i++){
            arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
        }

        StringBuilder answer = new StringBuilder();
        M = Integer.parseInt(br.readLine());
        int x, y;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            answer.append(arr[y] - arr[x-1]).append('\n');
        }

        System.out.println(answer);
    }
}
