package week03;

import java.util.*;

public class BOJ1303 {
    static Scanner sc = new Scanner(System.in);
    static int n;
    static int m;
    static char[][] war;

    public static void main(String[] args) {
        n = sc.nextInt();
        m = sc.nextInt();
        war = new char[m][n];

        //    병사 입력
        for (int i = 0; i < m; i++) {
            String input = sc.next();
            for (int j = 0; j < n; j++) {
                war[i][j] = input.charAt(j);
            }
        }

        int cnt;
        int wCnt = 0;
        int bCnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                //  방문하지 않았을 경우
                if (war[i][j] != 'V') {
                    //  조사하는 병사의 옷색 저장
                    char s = war[i][j];
                    cnt = bfs(i, j);
                    if (s == 'W') {
                        wCnt += cnt * cnt;
                    } else if (s == 'B') {
                        bCnt += cnt * cnt;
                    }
                }
            }
        }
        //  결과 출력
        System.out.println(wCnt + " " + bCnt);
    }

    // bfs 함수
    public  static int bfs(int i, int j) {
        Queue<List<Integer>> queue = new LinkedList<>();
        //  탐색하려는 옷색
        char c = war[i][j];
        //  병사 몇명인지
        int cnt = 1;
        //  상하좌우
        int[][] dirct = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        queue.add(Arrays.asList(i, j));
        //  처음 탐색한 병사 방문 처리
        war[i][j] = 'V';

        //  queue가 빌때까지 반복
        while (!queue.isEmpty()) {
            List<Integer> cur = queue.poll();
            int a = cur.get(0);
            int b = cur.get(1);

            //  상하좌우 탐색
            for (int[] dir : dirct) {
                int x = a + dir[0];
                int y = b + dir[1];

                //  범위에 해당하고 옷 색이 같을 경우
                if (x >= 0 && x < m && y >= 0 && y < n && war[x][y] == c) {
                    cnt++;
                    queue.add(Arrays.asList(x, y));
                    //  방문 처리
                    war[x][y] = 'V';
                }
            }
        }
        return cnt;
    }
}
