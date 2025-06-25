package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_21758 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] honey = new int[n];
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) honey[i] = Integer.parseInt(s[i]);

        long[] prefix = new long[n];
        prefix[0] = honey[0];
        for (int i = 1; i < n; i++) prefix[i] = prefix[i-1] + honey[i];

        long answer = 0;

        // 1. 벌통이 맨 오른쪽
        for (int i = 1; i < n-1; i++) {
            long temp = prefix[n-1] - honey[0] - honey[i] + prefix[n-1] - prefix[i];
            answer = Math.max(answer, temp);
        }
        // 2. 벌통이 맨 왼쪽
        for (int i = n-2; i > 0; i--) {
            long temp = prefix[n-2] - honey[i] + prefix[i-1];
            answer = Math.max(answer, temp);
        }
        // 3. 벌통이 가운데
        for (int i = 1; i < n-1; i++) {
            long temp = prefix[i] - honey[0] + prefix[n-2] - prefix[i-1];
            answer = Math.max(answer, temp);
        }
        System.out.println(answer);
    }
}

}
