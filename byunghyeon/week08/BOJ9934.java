package week08;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ9934 {
    static int N;
    static List<List<Integer>> tree = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            tree.add(new ArrayList<>());
        }

        int numNode = (int)Math.pow(2, N) - 1;
        int[] treeArr = new int[numNode+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < numNode; i++){
            treeArr[i] = Integer.parseInt(st.nextToken());
        }

        binaryOrder(treeArr, 0, numNode, 0);

        StringBuilder answer = new StringBuilder();
        for (List<Integer> integers : tree) {
            for (Integer integer : integers) {
                answer.append(integer).append(" ");
            }
            answer.append("\n");
        }
        System.out.print(answer);
    }

    public static void binaryOrder(int[] treeArr, int start, int end, int depth){
        int mid = (start + end)/2;

        if(depth >= N) return;
        tree.get(depth).add(treeArr[mid]);

        if(start >= end) return;

        binaryOrder(treeArr, start, mid-1, depth+1);
        binaryOrder(treeArr, mid+1, end, depth+1);
    }
}
