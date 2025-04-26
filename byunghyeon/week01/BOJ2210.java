package week01;

/*
* BOJ2210 - 숫자판 점프
* 알고리즘 - DFS
* 각 배열의 요소를 돌아다니면서 각 방향마다 DFS를 통해서 수들을 만든다.
* 이때 DFS를 위해 Queue를 이용하며 방향은 동서남북, 4개의 방향으로 한다.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2210 {

    static Set<String> strings = new HashSet<>();
    static int[][] table;

    static int[] moveX = {1, 0, -1, 0};
    static int[] moveY = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        // 5x5 숫자판
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // table 생성
        table = new int[5][5];
        for(int i = 0; i < 5; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++){
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringBuilder string;
        // 만들 수 있는 6자리 수 구하기
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                string = new StringBuilder();
                dfs(i, j, string);
            }
        }

        System.out.println(strings.size());
    }

    private static void dfs(int x, int y, StringBuilder string) {

        if(string.length() >= 6){
            strings.add(string.toString());
            return;
        }

        Queue<Point> queue = new LinkedList<>();

        for(int i = 0; i < 4; i++) {
            int movedX = x + moveX[i];
            int movedY = y + moveY[i];
            if (movedX < 0 || movedY < 0) continue;
            if (movedX >= 5 || movedY >= 5) continue;

            queue.add(new Point(movedX, movedY));
        }

        while(!queue.isEmpty()){
            Point point = queue.poll();
            int num = table[point.x][point.y];

            string.append(num);
            dfs(point.x, point.y, string);
            string.setLength(string.length()-1);
        }
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
