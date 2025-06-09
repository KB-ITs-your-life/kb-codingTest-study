package week04;
import java.util.*;

public class BOJ2164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

        while (q.size() >= 2) {
            q.poll();
            int num = q.remove();
            q.add(num);
        }
        System.out.println(q.element());
    }
}
