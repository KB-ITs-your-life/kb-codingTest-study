package week03;

/*
* 단지번호붙이기
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2667 {
    static int N; // 5 <= N <= 25
    static char[][] map;
    static int[] dx = {1, 0 , -1, 0};
    static int[] dy = {0, 1 , 0, -1};

    static ArrayList<Integer> answer = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1. 입력
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for(int i = 0; i < N; i++){
            String row = br.readLine();
            for(int j = 0; j < N; j++){
                map[i][j] = row.charAt(j);
            }
        }

        // BFS - 왜 BFS를 했느냐 => 영역을 찾는 것이기 때문에 주변부터 보는 것이 적절하다고 생각
        // 해당 문제 같은 경우는 N이 5와 25사이여서 무엇을 쓰든 괜찮지만 커지면 재귀의 깊이가 깊어질 것이라고 생각합니다.
        // 찾아보니 java는 스택 크기가 커서 상관없다고 하고, 파이썬 같은 경우는 BFS가 안전하다고 합니다.
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){  // 1. 테이블을 순회하면서 '0'이 아닌 곳을 찾는다.
                if(map[i][j] != '0')
                    bfs2667(i, j);
            }
        }

        // 정렬 후 정답 출력
        Collections.sort(answer); // 7. 영역의 크기들을 정렬한다.
        StringBuilder ans = new StringBuilder(); // 영역들이 많을 수 있어서 StringBuilder로 한번에 출력했다.
        ans.append(answer.size()).append('\n');
        for (Integer element : answer) {
            ans.append(element).append('\n');
        }

        System.out.println(ans);
    }
    private static void bfs2667(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y)); // 2. 처음에 '1'인 곳의 위치를 큐에 넣는다.
        int area = 0;

        while(!queue.isEmpty()){
            Point point = queue.poll(); // 3. 큐에서 '1'인 곳의 위치를 꺼낸다.
            // 첨에 앞에 0을 검사했는데 왜 또 하냐!? => 이미 검사한 어떤 한 곳('0'이 된 곳)을 두 번 검사할 때가 있다 (ㄱ 같은 경우) 그럼 카운트가 증가된다.
            if(map[point.x][point.y] == '0') continue;
            map[point.x][point.y] = '0';

            area += 1;

            for(int i = 0; i < 4; i++){ // 4. '1'인 곳의 동서남북을 검사 후 '1'(갈 수 있는 곳)을 큐에 삽입
                int newX = point.x + dx[i];
                int newY = point.y + dy[i];

                if(newX < 0 || newX >= N) continue;
                if(newY < 0 || newY >= N) continue;
                if(map[newX][newY] != '0')
                    queue.add(new Point(newX, newY));
            }
        } // 5. 이후 반복

        // 큐가 비게 되면 이땐 영역의 크기를 구한 상태다
        answer.add(area); // 6. 영역 크기 리스트에 삽입
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
