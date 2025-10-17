package week12;

import java.util.*;
import java.io.*;

public class BOJ_16928 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());  // 사다리 수
        int m = Integer.parseInt(st.nextToken());  // 뱀의 수

        Map<Integer, Integer> ladderNsnake = new HashMap<>();
        int[] dist = new int[101];           // 각 칸까지의 최소 이동 횟수
        boolean[] visited = new boolean[101];

        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            ladderNsnake.put(x, y);
        }

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int i = 1; i <= 6; i++) {
                int next = curr + i;
                if (next > 100) continue;

                int dest = ladderNsnake.getOrDefault(next, next);

                if (!visited[dest]) {
                    visited[dest] = true;
                    dist[dest] = dist[curr] + 1;
                    queue.offer(dest);
                }
            }
        }

        System.out.println(dist[100]);
    }


}
