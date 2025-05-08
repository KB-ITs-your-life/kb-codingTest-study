package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* DP 조건
 * 1. 겹치는 소문제 : 문제를 작게 나누고 결과를 재사용해서 원하는 결과 도출
 * 2. 최적 부분 구조 : 소문제 최적 결과로 전체 문제의 최적 결과를 낼수 있는가?
 * 소문제의 결과를 저장하고 결과값 도출 조건을 구해둔다.
 * */

public class BOJ_1309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());

        int[][] lion=new int[N+1][N+1]; // [동물의수][우리 크기]
        //최대로 들어갈 수 있는 사자는 N마리이다.
        //0마리에서 N마리까지 반복..?
        //0마리이면 경우의 수 1개
        lion[0][0]=1;
        //1마리이면 경우의 수 = 우리 개수

        for(int i=2;i<=N;i++){
            lion[i][i]=2;
        }
        // 점화식
        // (현재 동물 N에 동물 i마리 들어가는 경우의수) =
        // (n-2크기에 i-1마리) * 2 + (n-1크기에 i마리) + (((N-(i-1))*2-1)*2)(=맨위에서부터 동물적재)
        for(int k=2;k<=N;k++){  //크기
            for(int i=2;i<=N;i++){
                lion[k][i]=(lion[k-2][i-1]*2)+lion[k-1][i]+((k-(i-1))*2-1)*2;
                System.out.println("k : "+k+" i : "+i+" lion : "+lion[k][i]);
            }
        }
        System.out.println(lion[N][N]);






    }
}
