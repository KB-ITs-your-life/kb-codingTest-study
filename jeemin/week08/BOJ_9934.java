package week08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_9934 {
    static int[] arr;
    static List<List<Integer>> result = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            result.add(new ArrayList<>());
        }

        String[] input = br.readLine().split(" ");
        arr = new int[input.length];
        for (int i = 0; i < input.length; ++i) {
            arr[i] = Integer.parseInt(input[i]);
        }
        DFS(0, arr.length, 0);
        for(List<Integer> list : result) {
            for(Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }

    static void DFS(int start, int end, int depth) {
        int idx = (start + end - 1) / 2;
        int node = arr[idx];
        result.get(depth).add(node);
        if (end - start == 1) {
            return;
        }
        DFS(start, idx, depth + 1);
        DFS(idx + 1, end, depth + 1);
    }
}
