package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_19542 {
    static List<List<Integer>> tree;
    static boolean[] visited;
    static int[] subDistance;
    static int visitNode;       //꼭 가야하는 노드
    static int S;
    static int D;




    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        tree = new ArrayList<>();
        visited = new boolean[N+1];
        subDistance = new int[N+1];

        for(int i=0;i<=N;i++){
            tree.add(new ArrayList<>());
        }

        for(int i=1;i<N;i++){

            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            tree.get(x).add(y);
            tree.get(y).add(x);
        }

        // 시작 노드가 가진 자식 노드의 깊이를 dfs로 확인하고
        // D보다 크면 방문노드를 개수를 더하기.
        // 방문노드 곱하기 2하면 최소 거리가 출력.
        dfs(S,-1);

        System.out.println(visitNode *2);




    }
    // 최대 깊이 구하기.
    static int dfs(int start,int prev){
        // start노드의 최대 깊이
        int max=0;

        // start와 연결된 노드 하나씩 순회
        for(int next:tree.get(start)){
            if(next!=prev){
                // start의 자식노드들의 최대 깊이와 start노드가 가지고있는 최대 깊이 비교
                max=Math.max(max,dfs(next,start)+1);
            }
        }
        // 현재 노드가 시작이 아니고 깊이가 현민이의 힘 D와 같거니 클때
        // 이 노드의 서브트리에서 루트까지의 거리가 D 이상인 자식 노드가 있다면
        // 꼭 가야하므로 visitNode++

        if(start!=S&&max>=D){
            visitNode++;
        }
        return max;
    }
}




















