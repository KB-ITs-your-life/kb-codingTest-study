package week03;

import java.util.*;

public class BOJ16953 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int result = solution(a, b);
        System.out.println(result);
    }

    public static int solution(int a, int b){
        int cnt = 1;
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(Arrays.asList(b, cnt));
        while (!queue.isEmpty()) {
            List<Integer> l = queue.poll();
            int n = l.get(0);
            cnt = l.get(1);

            if (n == a) return cnt;

            if (n % 10 == 1) {
                queue.add(Arrays.asList((n - 1) / 10, cnt + 1));
            } else if (n % 2 == 0 && n != 0) {
                queue.add(Arrays.asList((n / 2), cnt + 1));
            }
        }
        return -1;
    }
}

