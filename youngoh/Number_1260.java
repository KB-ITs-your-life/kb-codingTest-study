import java.io.BufferedReader;
import java.util.*;

public class Number_1260 {
    static boolean[] visited;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt();

        graph = new ArrayList[N + 1];
        for(int i = 1; i <= N; ++i) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; ++i) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }

        //문제에서 요구하는 "작은 번호부터 방문" 조건을 지키기 위해 정렬이 필수.
        for(int i = 1; i <= N; ++i) {
            Collections.sort(graph[i]);
        }

        visited = new boolean[N + 1];
        dfs(V);
        System.out.println();
        visited = new boolean[N + 1];
        bfs(V);
    }

    private static void dfs(int node) {
        visited[node] = true;

        System.out.print(node + " ");
        for(int next : graph[node]) {
            if(!visited[next]) {
                dfs(next);
            }
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.print(node + " ");

            for (int next : graph[node]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}
