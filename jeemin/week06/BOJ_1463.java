package week06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.*;

public class BOJ_1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[n + 1];

        Queue<List<Integer>> q = new LinkedList<>();
        q.add(Arrays.asList(n, 0));
        visited[0] = true;
        while (!q.isEmpty()) {
            List<Integer> l = q.poll();
            int num = l.get(0);
            int cnt  = l.get(1);
            if (num == 1) {
                System.out.println(cnt);
                break;
            }
            if (num % 3 == 0 && visited[num / 3] == false) {
                q.add(Arrays.asList(num / 3, cnt + 1));
                visited[num / 3] = true;
            }
            if (num % 2 == 0 && visited[num / 2] == false) {
                q.add(Arrays.asList(num / 2, cnt + 1));
                visited[num / 2] = true;
            }
            if (num > 1 && visited[num - 1] == false) {
                q.add(Arrays.asList(num - 1, cnt + 1));
                visited[num - 1] = true;
            }
        }
    }
}
