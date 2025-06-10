import java.util.PriorityQueue;
import java.util.Scanner;

public class BOJ1927 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i =0; i<n ;i++){
            int a = sc.nextInt();
            if(a == 0){
                if(pq.size() == 0){
                    System.out.println("0");
                }
                else{
                    System.out.println(pq.poll());
                }

            }
            else{
                pq.add(a);
            }
        }
    }
}
