package week06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            String[] input1 = br.readLine().split(" ");
            String[] input2 = br.readLine().split(" ");
            int[][] sticker = new int[2][n];
            for (int j = 0; j < n; ++j) {
                sticker[0][j] = Integer.parseInt(input1[j]);
            }
            for (int j = 0; j < n; ++j) {
                sticker[1][j] = Integer.parseInt(input2[j]);
            }
            sticker[0][1] += sticker[1][0];
            sticker[1][1] += sticker[0][0];

            for (int j = 2; j < n; ++j) {
                sticker[0][j]  += Math.max(sticker[1][j - 1], sticker[1][j - 2]);
                sticker[1][j]  += Math.max(sticker[0][j - 1], sticker[0][j - 2]);
            }

            System.out.println(Math.max(sticker[0][n - 1], sticker[1][n - 1]));
        }
    }
}
