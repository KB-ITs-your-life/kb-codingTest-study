import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Number_2667 {
    static int N;
    static int[][] grid;
    static boolean[][] visited;

    //방향 배열
    static int[] up = {-1,1,0,0}; // x좌표 기준 → 위, 아래
    static int[] down = {0,0,-1,1}; // y좌표 기준 → 왼쪽, 오른쪽

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(bufferedReader.readLine());
        grid = new int[count][count];
        visited = new boolean[count][count];

        for(int i = 0; i < count; ++i) {
            int[] input = Arrays.stream(bufferedReader.readLine().split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            grid[i] = input;
        }

        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < N; ++i) {
            for(int j = 0; j < N; ++j) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    int houseCount = bfs(i,j);
                    result.add(houseCount);
                }
            }
        }

        Collections.sort(result);
        System.out.println(result.size());
        for(int s : result) {
            System.out.println(s);
        }
    }

    private static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.add(new int[]{x, y});

        int count = 1;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];
        }
    }
}
