package week08;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ19542 {
    static Map<Integer, TreeNode> treeMap = new HashMap<>();
    static boolean[] isVisited;
    static int N,S,D;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        isVisited = new boolean[N+1];

        // 트리 생성
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            treeMap.putIfAbsent(v1, new TreeNode(v1));
            treeMap.putIfAbsent(v2, new TreeNode(v2));

            treeMap.get(v1).addEdge(v2);
            treeMap.get(v2).addEdge(v1);
        }

        deliverPaper(S, D);

    }

    private static Response deliverPaper(int start, int power) {
        if(isVisited[start]) return new Response(0, false);
        isVisited[start] = true;

        TreeNode treeNode = treeMap.get(start);
        List<Integer> edges = treeNode.edges;

        if(edges.isEmpty()) return new Response(1, false);

        int[] mDis = new int[edges.size()];
        int seq = 0;
        boolean isSub = false;
        for (Integer edge : edges) {
            Response res = deliverPaper(edge, power);
            if(res.isGo) isSub = true;
            mDis[seq++] = res.acc;
        }

        int max = Arrays.stream(mDis).max().getAsInt();

        if(max < D){
            if(isSub) return new Response(max+1, true);
            else return new Response(max+1 , false);
        }

        int acc = 0;
        for (int m : mDis) {
            acc += max > D ? max - D : 0;
        }

        return new Response(acc+1, true);
    }

    static class Response{
        int acc;
        boolean isGo;
        public Response(int acc, boolean isGo){
            this.acc = acc;
            this.isGo = isGo;
        }
    }

    static class TreeNode{
        int num;
        List<Integer> edges;
        public TreeNode(int num){
            this.num = num;
            this.edges = new ArrayList<>();
        }

        public void addEdge(int node){
            edges.add(node);
        }
    }
}
