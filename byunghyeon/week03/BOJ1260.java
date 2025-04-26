package week03;

/*
* DFS와 BFS
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1260 {
    static int N, M, V;
    static boolean[] isVisited;
    static StringBuilder answer = new StringBuilder();
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>(); // 인접 리스트
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 정점 개수
        M = Integer.parseInt(st.nextToken()); // 간선 개수
        V = Integer.parseInt(st.nextToken()); // 시작 정점

        for(int i = 0; i < N; i++){
            list.add(new ArrayList<>());
        }


        int start, end;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken())-1;
            end = Integer.parseInt(st.nextToken())-1;

            list.get(start).add(end); // 무방향 그래프
            list.get(end).add(start);
        }

        for(int i = 0; i < N; i++){
            Collections.sort(list.get(i)); // 각 리스트마다 오름차순으로 정렬
        }

        isVisited = new boolean[N]; // 방문 여부 초기화
        dfs1260();
        isVisited = new boolean[N]; // 방문 여부 초기화
        bfs1260();
        System.out.println(answer);
    }

    private static void bfs1260() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(V-1);
        while(!queue.isEmpty()){
            Integer poll = queue.poll();
            if(isVisited[poll]) continue;

            isVisited[poll] = true;
            answer.append(poll+1).append(" "); // 방문한 순서대로 정답에 삽입

            ArrayList<Integer> integers = list.get(poll);
            for (Integer integer : integers) {
                queue.add(integer);
            }
        }
        answer.append('\n');
    }

    private static void dfs1260() {
        Stack<Integer> stack = new Stack<>();
        stack.add(V-1);
        while(!stack.isEmpty()){
            Integer pop = stack.pop();

            if(isVisited[pop]) continue;

            isVisited[pop] = true;
            answer.append(pop+1).append(" "); // 방문한 순서대로 정답에 삽입

            ArrayList<Integer> integers = list.get(pop);

            for(int i = integers.size()-1; i >= 0; i--){ // 낮은 숫자부터 정답에 넣어야 하기에 큰 수부터 삽입
                int element = integers.get(i);
                stack.add(element);
            }
        }
        answer.append('\n');
    }
}