import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ2075 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            String[] s= br.readLine().split(" ");
            for (int j =0; j <n ; j++){
                int a = Integer.parseInt(s[j]);
                pq.offer(a);
                if(pq.size() > n){
                    pq.poll();
                }
            }
        }
        System.out.println(pq.peek());
    }
}
