package week08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ11437 {
    static List<Integer>[] tree;
    static boolean[] isVisited;
    static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 조건 입력
        int N = Integer.parseInt(br.readLine()); // 정점 개수 (2이상)

        // 트리 생성
        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) tree[i] = new ArrayList<>();

        StringTokenizer st;
        for(int i = 0; i < N-1; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            tree[v1].add(v2);
            tree[v2].add(v1);
        }

        // 알고싶은 공통 조상 쌍 개수
        StringBuilder a = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++){
            isVisited = new boolean[N+1];
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            // Lowest Common Ancestor
            LCA(1, start, target);

        }

        System.out.print(answer);

    }

    private static int LCA(int node, int start, int target) {

        if(isVisited[node]) return 0;
        isVisited[node] = true;

        List<Integer> edges = tree[node];

        int count = 0;
        for (Integer edge : edges) {
            count += LCA(edge, start, target);
        }
        if(node == start || node == target){
            if(count == 0)
                return 1;
            else if(count == 1){
                answer.append(node).append('\n');
                return 0;
            }
        }else{
            if(count == 1) return 1;
        }

        if(count == 2) {
            answer.append(node).append('\n');
            return 0;
        }

        return 0;
    }

}
