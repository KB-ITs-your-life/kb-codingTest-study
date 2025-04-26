import java.util.ArrayList;
import java.util.Scanner;

//입력
//n(노드 개수)와 m(간선 개수)를 입력받는다.
//
//그래프 초기화
//graph[i]가 인접 리스트가 되도록 ArrayList 배열을 만들고,
//visited[i] 배열로 방문 여부를 관리한다.
//
//간선 정보 저장
//양쪽 방향 모두에 add()하여 무향 그래프를 구성한다.
//
//DFS 호출
//시작 노드를 1번으로 정하고 dfs(1) 실행.
//
//연결 노드 개수 출력
//DFS 과정에서 방문한(연결된) 노드 수를 count에 누적해 두었다가 출력.

public class prac_Number_2606 {
    // 방문 여부 결정
    static boolean[] visited;

    // 배열의 인덱스는 번호에 해당하고, 각 배열에는 해당 번호와 연결된 번호들이 리스트로 저장됨
    static ArrayList<Integer>[] graph;

    // 1에서부터 연결된 노드 개수
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 노드 개수
        int m = sc.nextInt(); // 간선 개수

        // 인덱스와 번호를 동일하게 저장하기 위해 노드 개수 + 1 만큼 크기 할당
        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        // 노드 개수 + 1 민큼 크기를 할당하고, 각 배열에 어레이리스트 할당
        for(int i = 1; i <= n; ++i) {
            graph[i] = new ArrayList<>();
        }

        // 간선의 개수만큼 입력을 받음
        for(int i = 0; i < m; ++i) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            // 무방향 그래프이기 때문에 양쪽으로 연결
            graph[a].add(b);
            graph[b].add(a);
        }

        // dfs 탐색을 1 부터 시작
        dfs(1);

        System.out.println(count);
    }

    private static void dfs(int node) {

        // 현재 노드를 true 로 지정하여 방문으로 표시
        visited[node] = true;

        // 현재 노드의 리스트를 순회하며, 1번과 연결된 모든 노드를 탐색
        for(int next : graph[node]) {
            if(!visited[next]) {
                count++;
                dfs(next);
            }
        }
    }
}
