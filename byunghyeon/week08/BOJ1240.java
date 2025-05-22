package week08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ1240 {
    static Map<Integer, TreeNode> treeMap;
    static boolean[] isVisited;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 조건 입력
        N = Integer.parseInt(st.nextToken()); // 노드 개수
        M = Integer.parseInt(st.nextToken()); // 거리 알고 싶은 쌍 개수
        isVisited = new boolean[N+1];

        // 트리 생성
        treeMap = new HashMap<>();
        for(int i = 0; i < N-1; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            treeMap.putIfAbsent(v1, new TreeNode(v1));
            treeMap.putIfAbsent(v2, new TreeNode(v2));

            treeMap.get(v1).addEdge(v2, w);
            treeMap.get(v2).addEdge(v1, w);
        }

        // 거리 구하기
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < M; i++) {
            isVisited = new boolean[N+1];
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = findTarget(start, end, 0);
            answer.append(distance).append('\n');
        }
        System.out.print(answer);
    }

    private static int findTarget(int start, int target, int distance){
        if(isVisited[start]) return -1;
        isVisited[start] = true;

        TreeNode treeNode = treeMap.get(start);
        if(start == target){
            return distance;
        }

        Map<Integer, Integer> edges = treeNode.edges;

        for (Integer nodeNum : edges.keySet()) {
            int plusDistance = findTarget(nodeNum, target, distance + edges.get(nodeNum));
            if(plusDistance != -1)
                return plusDistance;
        }
        return -1;
    }

    static class TreeNode{

        int num; // 자신의 노드 번호
        Map<Integer, Integer> edges = new HashMap<>(); //연결된 노드와 가중치

        public TreeNode(int num){
            this.num = num;
        }

        public void addEdge(int to, int weight){
            edges.put(to, weight);
        }
    }
}
