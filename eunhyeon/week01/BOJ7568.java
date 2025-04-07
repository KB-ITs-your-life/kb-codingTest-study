package week01;

// 덩치

import java.util.Arrays;
import java.util.Scanner;

public class BOJ7568 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] people = new int[N][2];

        for (int i = 0; i < N; i++) {
            people[i][0] = sc.nextInt(); // 몸무게
            people[i][1] = sc.nextInt(); // 키
        }

        int[] ranks = new int[N];
        Arrays.fill(ranks, 1); // 모든 사람의 초기 등수를 1로 설정

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i != j && people[i][0] < people[j][0] && people[i][1] < people[j][1]) {
                    ranks[i]++; // 자신보다 더 큰 덩치의 사람이 있을 경우 등수 증가
                }
            }
        }

        for (int rank : ranks) {
            System.out.print(rank + " ");
        }
    }
}
