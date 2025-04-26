package week04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2167 {

    static int N,M;
    static int K;
    static int[][] arr2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N, M 입력
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 배열 입력
        arr2 = new int[N+1][M+1];
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= M; j++){
                arr2[i][j] += arr2[i][j-1] + Integer.parseInt(st.nextToken());
            }
        }

        // K 입력
        K = Integer.parseInt(br.readLine());

        // 좌표 입력
        int x1, x2, y1, y2;
        int total = 0;
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());

            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            for(int k = x1; k <= x2; k++){
                total += (arr2[k][y2] - arr2[k][y1-1]);
            }

            answer.append(total).append('\n');
            total = 0;
        }

        System.out.println(answer);

    }
}


/*
* 1 3 7
* 8 24 56
*
* 1  3  7
* 15 31 63
* */