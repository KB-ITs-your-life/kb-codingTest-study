package week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15649 {
    static int N,M;
    static boolean[] isVisited;
    static int[] store;

    static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 최대 수
        N = Integer.parseInt(st.nextToken());
        // depth
        M = Integer.parseInt(st.nextToken());

        isVisited = new boolean[N+1];
        store = new int[M+1];

        dfs(1);
        System.out.println(answer);
    }

    private static void dfs(int stage) {
        if(stage > M){
            for(int i = 1; i <= M; i++){
                answer.append(store[i]).append(" ");
            }
            answer.append('\n');
            return;
        }

        for(int i = 1; i <= N; i++){
            if(!isVisited[i]){
                isVisited[i] = true;
                store[stage] = i;
                dfs(stage+1);
                isVisited[i] = false;
            }
        }

    }
}
