package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11404 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 도시 개수
        int m = Integer.parseInt(br.readLine()); // 간선 개수

        int[][] table = new int[n+1][n+1];
        for(int i = 1; i <=n; i++){
            for(int j = 1; j <= n; j++){
                if(i == j) table[i][j] = 0;
                else table[i][j] = Integer.MAX_VALUE;
            }
        }

        for(int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            table[start][end] = Math.min(table[start][end], cost);
        }

        // 플로이드 워셜 알고리즘
        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    if (table[i][k] != Integer.MAX_VALUE && table[k][j] != Integer.MAX_VALUE)
                        table[i][j] = Math.min(table[i][j], table[i][k] + table[k][j]);
                }
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++){
                if(table[i][j] == Integer.MAX_VALUE)
                    answer.append(0).append(" ");
                else
                    answer.append(table[i][j]).append(" ");
            }
            answer.append("\n");
        }
        System.out.print(answer);

    }
}
