package week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1182 {

    static int N,S;
    static int count = 0;
    static int[] sequence;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 주어진 정수
        S = Integer.parseInt(st.nextToken()); // goal sum

        sequence = new int[N];
        isVisited = new boolean[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        dfs1182(0 , 0);

        // 공집합(아무것도 선택 안 한 경우) 제외
        if (S == 0) count--;

        System.out.println(count++);
    }

    private static void dfs1182(int depth, int sum) {
        if (depth == N) {
            if (sum == S) count++;
            return;
        }

        // 현재 원소 선택
        dfs1182(depth + 1, sum + sequence[depth]);

        // 현재 원소 선택 안 함
        dfs1182(depth + 1, sum);

    }

}
