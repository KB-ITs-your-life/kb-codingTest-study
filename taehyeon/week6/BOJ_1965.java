package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* DP 조건
* 1. 겹치는 소문제 : 문제를 작게 나누고 결과를 재사용해서 원하는 결과 도출
* 2. 최적 부분 구조 : 소문제 최적 결과로 전체 문제의 최적 결과를 낼수 있는가?
* 소문제의 결과를 저장하고 결과값 도출 조건을 구해둔다.
* */


public class BOJ_1965 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] box=new int[n];
        int[] dp=new int[n];
        for(int i=0;i<n;i++){
            box[i]=Integer.parseInt(st.nextToken());
        }
        // 1. 이전 박스가 나보다 작다면 이전 박스가 넣을 수 있는 박스+1
        // 2. DP와 LIS 알고리즘(Longest Increasing Subsequence)를 활용
        // 3. 현재 선택 박스 이전의 박스들을 확인
        // 3-1. 이전의 박스가 현재 선택 박스보다 작으면 이전의 박스 +1과 현재 박스 쌓인 박스 비교
        // 4. 더 큰 것을 현재 쌓인 박스로 변경.
        // 5. 최대 값 비교.
        int max=1;
        for(int i=0;i<n;i++){
            // 기저 사례
            dp[i]=1;
            for(int j=0;j<i;j++){
                // 전처리 로직
                if(box[i]>box[j]){//이전의 박스 크기와 비교하여 이전꺼보다 크면
                    //점화식
                    dp[i]=Math.max(dp[i],dp[j]+1);  //현재 탐색하는 쌓인 박스 개수와 비교.
                }
            }
            max=Math.max(max,dp[i]); //최대 상자 개수 판별.
        }

        System.out.println(max);


    }

}
