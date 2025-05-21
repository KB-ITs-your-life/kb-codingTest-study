package week05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("-");

        for (int i = 0; i < input.length; ++i) {
            String[] s = input[i].split("[+]");
            if (s.length > 1) {
                int sum = 0;
                for (String num : s) {
                    sum += Integer.parseInt(num);
                }
                input[i] = String.valueOf(sum);
            }
        }
        int result = Integer.parseInt(input[0]);
        for (int i = 1; i < input.length; ++i) {
            result -= Integer.parseInt(input[i]);
        }
        System.out.println(result);
    }
}
