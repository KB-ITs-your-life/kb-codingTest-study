package week06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int[] arr0 = new int[41];
        int[] arr1 = new int[41];
        arr0[0] = 1;
        arr1[0] = 0;
        arr0[1] = 0;
        arr1[1] = 1;
        for (int i = 2; i < 41; i++) {
            arr0[i] = arr0[i - 1] + arr0[i - 2];
            arr1[i] = arr1[i - 1] + arr1[i - 2];
        }
        for (int i = 0; i < t; ++i) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(arr0[n] + " " + arr1[n]);
        }

    }
}
