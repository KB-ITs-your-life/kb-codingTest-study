

package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1260 {
    static int N;
    static int M;
    static int V;
    static int start;
    static boolean[] visited;
    static int graph[][];
    static Queue<Integer> queue;
    static StringBuilder sb = new StringBuilder();

    public static void bfs(int v) {
        visited[v]=true;
        queue.offer(v);
        System.out.print(v + " ");

        while(!queue.isEmpty()){
            start = queue.poll();
            if (!visited[start]){
                System.out.print(start + " ");
            }

            for(int i=1;i<=N;i++){
                if(!visited[i] && graph[start][i]==1){
                    queue.offer(i);
                    visited[i]=true;
                    System.out.print(i+" ");
                }
            }
        }
    }

    public static void dfs(int v) {
        visited[v] = true;
        System.out.print(v + " ");
        if (v == graph.length) {
            return;
        }

        for(int i=1;i<=N;i++){
            if(!visited[i] && graph[v][i]==1){
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        queue = new LinkedList<Integer>();

        graph=new int[N+1][N+1];
        visited=new boolean[N+1];

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());

            graph[x][y]=graph[y][x]=1;
        }
        dfs(V);
        System.out.println();
        visited=new boolean[N+1];

        bfs(V);

    }
}