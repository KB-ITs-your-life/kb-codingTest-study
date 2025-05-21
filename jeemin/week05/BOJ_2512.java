package week05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] budget = new int[n];
        for (int i = 0; i < n; i++) {
            budget[i] = Integer.parseInt(input[i]);
        }

        int total = Integer.parseInt(br.readLine());

        int s = 0;
        int e = total;
        while (s <= e) {
            int mid = (s + e) / 2;
            int sum = 0;
            for (int b : budget) {
                if (b < mid) {
                    sum += b;
                } else {
                    sum += mid;
                }
            }
            if (sum < total) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        System.out.println(e);
    }
}
