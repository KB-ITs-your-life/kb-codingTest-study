package week05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        String[] input1 = br.readLine().split(" ");
        int[] nums = new int[m];
        for (int i = 0; i < m; i++) {
            nums[i] = Integer.parseInt(input1[i]);
        }

        for (int num : nums) {
            int start = 0;
            int end = n - 1;
            boolean flag = true;
            while (start <= end) {
                int mid = (start + end) / 2;
                if (arr[mid] == num) {
                    System.out.println(1);
                    flag = false;
                    break;
                }
                if (arr[mid] > num) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            if (flag) {System.out.println(0);}
        }
    }
}
