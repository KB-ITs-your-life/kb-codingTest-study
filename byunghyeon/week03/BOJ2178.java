package week03;

/*
* 미로찾기
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2178 {
    static int N, M;
    static char[][] maze;
    static int answer;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new char[N][M];
        for(int i = 0; i < N; i++){
            String row = br.readLine();
            for(int j = 0; j < M; j++){
                maze[i][j] = row.charAt(j);
            }
        }
        bfs2178(0 ,0, 1);
        System.out.println(answer);
    }

    private static void bfs2178(int x, int y, int depth) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x,y, depth));

        while(!queue.isEmpty()){
            Point point = queue.poll();
            if(maze[point.x][point.y] == '0') continue;

            maze[point.x][point.y] = '0';
            if(point.x == N-1 && point.y == M-1){
                answer = point.depth;
                return;
            }

            for(int i = 0; i < 4; i++){
                int newX = point.x + dx[i];
                int newY = point.y + dy[i];

                if(newX < 0 || newX >= N) continue;
                if(newY < 0 || newY >= M) continue;
                queue.add(new Point(newX, newY, point.depth+1));

            }
        }
    }
    static class Point{
        int x;
        int y;
        int depth;
        public Point(int x, int y, int depth){
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }
}
