package week08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ11437_2 {
    static List<Integer>[] tree;
    static boolean[] isVisited;
    static int[] depths, parents;
    static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 조건 입력
        int N = Integer.parseInt(br.readLine()); // 정점 개수 (2이상)
        depths = new int[N+1];
        parents = new int[N+1];
        isVisited = new boolean[N+1];

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

        // 부모와 노드 깊이 입력
        findDepthAndParent(1, 1);

        // 알고싶은 공통 조상 쌍 개수
        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            // Lowest Common Ancestor
            int commonParent = lca(start, target);
            answer.append(commonParent).append('\n');
        }

        System.out.print(answer);

    }

    private static int lca(int start, int target) {


        while (depths[start] != depths[target]){
            if(depths[start] < depths[target]){
                target = parents[target];
            }else {
                start = parents[start];
            }
        }

        while (start != target){
            start = parents[start];
            target = parents[target];
        }
        return start;
    }

    private static void findDepthAndParent(int node, int depth) {
        isVisited[node] = true;
        depths[node] = depth;

        for(Integer edge : tree[node]){
            if(!isVisited[edge]){
                parents[edge] = node;
                findDepthAndParent(edge, depth+1);
            }
        }

    }

}
