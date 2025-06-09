package week08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1967 {
    static Map<Integer, TreeNode> treeMap = new HashMap<>();
    static TreeNode root;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 조건 입력
        int N = Integer.parseInt(br.readLine());
        if(N == 1) {
            System.out.println(0); return;}

        // 트리 생성
        StringTokenizer st;
        for(int i = 0; i < N-1; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            treeMap.putIfAbsent(v1, new TreeNode(v1));
            treeMap.putIfAbsent(v2, new TreeNode(v2));

            treeMap.get(v1).addEdge(v2, w);
        }
        root = treeMap.get(1);

        // 트리의 지름 구하기
        // 1. 트리 부모노드에서 자식들의 거리를 구한다.
        int distance = findDistance(root, 0);
        max = Math.max(distance, max);

        System.out.println(max);

    }

    public static int findDistance(TreeNode parent, int weight){
        List<Edge> edges = parent.edges;
        if(edges.isEmpty()) return weight;

        int[] distances = new int[edges.size()];
        int seq = 0;
        for (Edge edge : edges) {
            TreeNode treeNode = treeMap.get(edge.target);
            int distance = findDistance(treeNode, edge.weight);
            distances[seq++] = distance;
        }
        Arrays.sort(distances);

        if(edges.size() == 1) return distances[distances.length-1] + weight;
        int localMax = distances[distances.length-1] + distances[distances.length-2];
        max = Math.max(localMax, max);

        return weight + distances[distances.length-1];
    }



    static class TreeNode{
        int num;
        List<Edge> edges = new ArrayList<>();
        public TreeNode(int num){
            this.num = num;
        }

        public void addEdge(int target, int weight){
            edges.add(new Edge(target, weight));
        }
    }

    static class Edge{
        int target;
        int weight;
        public Edge(int target, int weight){
            this.target = target;
            this.weight = weight;
        }
    }
}
