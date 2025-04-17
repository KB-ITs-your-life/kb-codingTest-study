import java.util.ArrayList;
import java.util.Scanner;

public class Number_2606 {
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        for(int i = 1; i <= n; ++i) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; ++i) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }

        dfs(1);

        System.out.println(count);
    }

    private static void dfs(int node) {
        visited[node] = true;

        for(int next : graph[node]) {
            if(!visited[next]) {
                count++;
                dfs(next);
            }
        }
    }
}
