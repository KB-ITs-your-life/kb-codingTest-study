package week08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1967 {
    static int result = 0;
    static HashMap<Integer, List<List<Integer>>> tree = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n - 1; ++i) {
            String[] input = br.readLine().split(" ");
            int parent = Integer.parseInt(input[0]);
            int child = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);

            tree.putIfAbsent(parent, new ArrayList<>());
            tree.get(parent).add(Arrays.asList(child, weight));
        }
        DFS(1);
        System.out.println(result);
    }

    static int DFS(int root) {
        if(!tree.containsKey(root)) return 0;

        int num = 0;
        List<Integer> sum = new ArrayList<>();
        int max1 = 0;
        int max2 = 0;
        for(List<Integer> list : tree.get(root)) {
            // 자식 노드 번호
            int childNode = list.get(0);
            // 자식 노드와 간선 값
            int edge = list.get(1);

            int dfsReturn = DFS(childNode);
            sum.add(edge + dfsReturn);
            num = Math.max(num, edge + dfsReturn);
        }
        for (int s : sum) {
            if (s > max1) {
                max2 = max1;
                max1 = s;
            }
            else if (s > max2) {
                max2 = s;
            }
        }
        result = Math.max(result, max1 + max2);
        return num;
    }
}
