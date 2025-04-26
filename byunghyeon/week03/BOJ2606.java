package week03;

/*
* 바이러스
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2606 {
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static int N, M;
    static int count = 0;
    static boolean[] isInfected;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        isInfected = new boolean[N];

        for(int i = 0; i < N; i++){
            list.add(new ArrayList<>());
        }

        StringTokenizer st;
        int start, end;
        for(int i= 0; i< M; i++){
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken()) - 1;
            end = Integer.parseInt(st.nextToken()) - 1;

            list.get(start).add(end);
            list.get(end).add(start);
        }

        bfs2606();
        System.out.println(count-1); // 1번은 뺌
    }

    private static void bfs2606() {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        while (!queue.isEmpty()){
            Integer poll = queue.poll();

            if(isInfected[poll]) continue;

            isInfected[poll] = true;
            count++;

            ArrayList<Integer> integers = list.get(poll);
            for(int i = 0; i < integers.size(); i++){
                queue.add(integers.get(i));
            }

        }

    }
}
