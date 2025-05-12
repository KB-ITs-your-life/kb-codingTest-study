package week6_7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1003 {
    static int[] n1=new int[41];  // n1[i] = fib(i)에서 0이 출력되는 횟수
    static int[] n2=new int[41];  // n2[i] = fib(i)에서 1이 출력되는 횟수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            int N = Integer.parseInt(br.readLine());

            fib(N);

            sb.append(n1[N]+" "+n2[N]).append("\n");


        }
        System.out.println(sb.toString());

    }
    /*Top-down : 시간초과

    public static int fib(int n){
        if(n==0){
            need[0]++;
            return 0;
        } else if(n==1){
            need[1]++;
            return 1;
        } else {
            return fib(n-1)+fib(n-2);
        }

    }
    */


    //Bottom-up
    public static void fib(int n) {
        // [1] 기저 사례 초기화: fib(0) 호출 시 0은 1번, 1은 0번 출력
        n1[0] = 1;  // n1[i] = fib(i)에서 0이 출력되는 횟수
        n2[0] = 0;  // n2[i] = fib(i)에서 1이 출력되는 횟수
        n1[1] = 0; // fib(1) → 0 출력 0회
        n2[1] = 1; // fib(1) → 1 출력 1회

        // [2] 단 한 번만 실행되는 전처리 로직
        if (n1[40] == 0) {  // 최대 입력값(40)까지 계산 여부 확인
            // [3] Bottom-up 방식으로 1~40까지 계산
            for(int i = 1; i < 41; i++) {
                // [4] 핵심 점화식 구현 부분
                n1[i] = n2[i-1];            // fib(i)의 0 호출 횟수 = fib(i-1)의 1 호출 횟수
                n2[i] = n1[i-1] + n2[i-1];  // fib(i)의 1 호출 횟수 = fib(i-1)의 1 호출 횟수
            }
        }
    }
}
