package week03;

/*
* 단지번호붙이기
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2667 {
    static int N;
    static char[][] map;
    static int[] dx = {1, 0 , -1, 0};
    static int[] dy = {0, 1 , 0, -1};

    static ArrayList<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for(int i = 0; i < N; i++){
            String row = br.readLine();
            for(int j = 0; j < N; j++){
                map[i][j] = row.charAt(j);
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(map[i][j] != '0')
                    bfs2667(i, j);
            }
        }

        Collections.sort(answer);
        StringBuilder ans = new StringBuilder();
        ans.append(answer.size()).append('\n');
        for (Integer element : answer) {
            ans.append(element).append('\n');
        }

        System.out.println(ans);
    }
    private static void bfs2667(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        int count = 0;

        while(!queue.isEmpty()){
            Point point = queue.poll();
            if(map[point.x][point.y] == '0') continue;
            map[point.x][point.y] = '0';

            count += 1;

            for(int i = 0; i < 4; i++){
                int newX = point.x + dx[i];
                int newY = point.y + dy[i];

                if(newX < 0 || newX >= N) continue;
                if(newY < 0 || newY >= N) continue;
                if(map[newX][newY] != '0')
                    queue.add(new Point(newX, newY));
            }
        }

        answer.add(count);
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
