package week01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BOJ10974 {
    static int N;
    static int[] arr;
    static boolean[] visited;

    // 순열을 저장할 리스트
    static List<String> permutations = new ArrayList<>();

    // 백트래킹을 이용한 순열 생성
    public static void generatePermutations(int depth) {
        if (depth == N) { // 모든 원소를 선택했으면
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                sb.append(arr[i]).append(" "); // 순열을 문자열로 저장
            }
            permutations.add(sb.toString().trim()); // 결과 리스트에 추가
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) { // 아직 사용하지 않은 숫자면
                visited[i] = true; // 사용 표시
                arr[depth] = i; // 현재 자리에 i를 넣음
                generatePermutations(depth + 1); // 다음 깊이로 재귀 호출
                visited[i] = false; // 사용한 숫자 다시 되돌림
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt(); // N 입력 받기
        arr = new int[N];
        visited = new boolean[N + 1]; // 1부터 N까지 사용할 것이므로 크기를 N+1로 설정

        generatePermutations(0); // 순열 생성 시작

        Collections.sort(permutations); // 사전순으로 정렬

        // 순열을 하나씩 출력
        for (String permutation : permutations) {
            System.out.println(permutation);
        }
    }
}
