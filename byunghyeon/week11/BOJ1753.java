package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1753 {

    static final int inf = Integer.MAX_VALUE;
    static List<Node>[] graph;
    static int[] table;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 정점, 간선 개수
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        // 그래프 초기화
        graph = new ArrayList[V+1];
        for(int i = 0; i <= V; i++){
            graph[i] = new ArrayList<>();
        }
        // 시작 노드
        int start = Integer.parseInt(br.readLine());
        // 간선 정보
        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, w)); // 여러 간선이 있을 수 있다.
        }

        // 다익스트라 적용 - 우선순위 큐
        int[] table = new int[V+1];
        Arrays.fill(table, inf);

        PriorityQueue<Node> pq = new PriorityQueue<>(); // 누적값 가짐
        pq.add(new Node(start, 0));
        table[start] = 0;
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            int curPos = cur.to;

            if(table[curPos] < cur.weight) continue;

            for(Node next : graph[curPos]){
                if(table[next.to] > table[curPos] + next.weight){
                    table[next.to] = table[curPos] + next.weight;
                    pq.add(new Node(next.to, table[next.to]));
                }
            }
        }

        StringBuilder answer = new StringBuilder();
        for(int i = 1; i <= V; i++){
            if(table[i] != inf){
                answer.append(table[i]).append("\n");
                continue;
            }
            answer.append("INF").append("\n");
        }

        System.out.println(answer);
    }



    static class Node implements Comparable<Node>{ // 기준1개는 Comparable 여러 개는 Comparator
        int to;
        int weight;
        public Node(int to, int weight){
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight; // 거리 오름차순
        }
    }
}
