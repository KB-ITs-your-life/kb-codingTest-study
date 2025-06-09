package week06;

/*
* 이진탐색 X
* LIS, DP 문제
* 소문제 - 한 줄에 넣을 수 있는 최대 상자 개수
* 소문제를 나누는 변수 - i (해당 위치에서의 최장 수열)
* 점화식 - MAX(f(1)...f(x-1)) + 1
* 초기값 - dp[1] = 1
* */
// 인덱스를 지나면서 이전값 중 현재보다 작은 수면서 최장 수열의 길이+1

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1965 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 상자 개수 입력
        N = Integer.parseInt(br.readLine());

        // 상자 크기 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] boxes = new int[N];
        for(int i = 0; i < N; i++){
            boxes[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        dp[0] = 1;
        // DP
        int max = 0;
        for(int i = 1; i < N; i++){
            max = 0;
            for(int j = i-1; j>=0; j--){
                if(boxes[i] > boxes[j] && dp[j] > max){
                    max = dp[j];
                }
            }
            dp[i] = max + 1;
        }
        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}