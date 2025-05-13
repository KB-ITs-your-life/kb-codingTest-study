package week07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_15988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        long[] sums = new long[1000001];
        sums[1] = 1;
        sums[2] = 2;
        sums[3] = 4;
        int max = 3;
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            if (sums[n] == 0) {
                if (n > max) {
                    for (int j = max + 1; j <= n; ++j) {
                        sums[j] = (sums[j - 1] + sums[j - 2] + sums[j - 3]) % 1000000009;
                    }
                    max = n;
                }
            }
            System.out.println(sums[n]);
        }
    }
}
