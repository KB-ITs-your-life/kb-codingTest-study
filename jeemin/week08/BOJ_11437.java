package week08;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BOJ_11437 {
    static List<Integer>[] tree;
    static int node1;
    static int node2;
    static int[] parent;
    static int[] depth;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        // 인접 리스트
        for (int i = 0; i < n - 1; ++i) {
            String[] s = br.readLine().split(" ");
            int n1 = Integer.parseInt(s[0]);
            int n2 = Integer.parseInt(s[1]);
            // 양방향 인접 리스트
            tree[n1].add(n2);
            tree[n2].add(n1);
        }

        parent = new int[n + 1];
        depth = new int[n + 1];
        visited = new boolean[n + 1];
        DFS(1, 0);


        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; ++i) {
            String[] s = br.readLine().split(" ");
            node1 = Integer.parseInt(s[0]);
            node2 = Integer.parseInt(s[1]);

            if (node1 == 1 || node2 == 1) {
                System.out.println(1);
                continue;
            }
            System.out.println(LCA(node1, node2));
        }
    }

    static void DFS(int root, int d) {
        visited[root] = true;
        depth[root] = d;
        for (Integer next : tree[root]) {
            if (!visited[next]) {
                parent[next] = root;
                DFS(next, d + 1);
            }
        }
    }

    static int LCA(int a, int b) {
        // 두 노드의 깊이 맞춰주기
        while (depth[a] != depth[b]) {
            if (depth[a] > depth[b]) {
                a = parent[a];
            } else {
                b = parent[b];
            }
        }
        // 두 노드의 공통 조상이 나올때까지 노드를 부모 노드로 올려주기
        while (a != b) {
            a = parent[a];
            b = parent[b];
        }
        return a;
    }
}