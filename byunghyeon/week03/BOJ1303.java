package week03;

/*
* 전쟁-전투
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1303 {
    static int N,M;
    static char[][] battleField;

    // 적
    static int bluePower = 0;
    // 나
    static int whitePower = 0;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력
        N = Integer.parseInt(st.nextToken()); // 가로
        M = Integer.parseInt(st.nextToken()); // 세로
        battleField = new char[M][N];

        // 전쟁터 입력
        for(int i = 0; i < M; i++){
            String row = br.readLine();
            for(int j = 0; j < N; j++){
                battleField[i][j] = row.charAt(j);
            }
        }

        for(int i = 0; i < M; i++){
            char[] row = battleField[i];
            for(int j = 0; j < N; j++){
                if(row[j] != 'X'){
                    bfs1303(i, j);
                }
            }
        }
        System.out.println(whitePower + " " + bluePower);
    }

    private static void bfs1303(int x, int y) {
        char start = battleField[x][y];
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x,y));
        int power = 0;
        while(!queue.isEmpty()){
            Point point = queue.poll();

            if(battleField[point.x][point.y] == 'X')
                continue;

            battleField[point.x][point.y] = 'X';
            power+=1;

            for(int i = 0; i < 4; i++){
                int newX = point.x + dx[i];
                int newY = point.y + dy[i];

                if(newX < 0 || newX >= M) continue;
                if(newY < 0 || newY >= N) continue;

                if(battleField[newX][newY] == start)
                    queue.add(new Point(newX, newY));
            }
        }

        if(start == 'W')
            whitePower+=power*power;
        else
            bluePower+=power*power;
    }

    static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
