package week04;
import java.util.Scanner;

public class BOJ11441 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] arr = new int[N+1];
        int[] sum = new int[N+1];
        arr[0] = 0;
        sum[0] = 0;

        for(int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
            sum[i] = sum[i-1] + arr[i];
        }
        int M = sc.nextInt();

        for(int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int result = sum[end] - sum[start-1];
            System.out.println(result);
        }

    }
}

