package week01;

/*
* BOJ12931 두 배 더하기
* 알고리즘 - 그리디(Greedy)
* 목표값에서 출발하며 각 자리마다 홀수인지 짝수인지 체크한다.
* 홀수면 1씩 줄이고 count를 증가시킨다.
* 그 이후 각 자리가 짝수로 맞춰졌을 때 각 자리를 2로 나누고 count를 증가시킨다.
* 이렇게 모든 요소가 0으로 될 때까지 반복한다.
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ12931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] goal = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            goal[i] = Integer.parseInt(st.nextToken());
        }

        int operations = 0;

        while (true) {
            boolean allZero = true;

            // 배열을 순회하면서 홀수면 -1
            for (int i = 0; i < N; i++) {
                if (goal[i] % 2 == 1) {
                    goal[i]--;
                    operations++; // 연산 1회 증가
                }
                if (goal[i] != 0) {
                    allZero = false;
                }
            }

            if (allZero) break;

            // 배열의 모든 요소가 모두 짝수일 때만 나누기 2
            for (int i = 0; i < N; i++) {
                goal[i] /= 2;
            }
            operations++; // 연산 1회 증가
        }

        System.out.println(operations);
    }
}

