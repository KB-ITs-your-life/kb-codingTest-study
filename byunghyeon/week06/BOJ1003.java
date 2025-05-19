package week06;

/*
* 소문제 - 0이 출력되는 횟수와 1이 출력되는 횟수 구하기
* 소문제를 나누는 변수 - i
* 점화식 - f(x-2) + f(x-1) = f(x)
* 초기값 - arr(0) = (1,0), arr(1) = (0,1)
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1003 {
    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        int[][] arr = new int[41][2];

        arr[0][0] = 1;
        arr[0][1] = 0;

        arr[1][0] = 0;
        arr[1][1] = 1;

        for(int i = 2; i <= 40; i++){
            arr[i][0] = arr[i-2][0] + arr[i-1][0];
            arr[i][1] = arr[i-2][1] + arr[i-1][1];
        }

        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < T; i++){
            int N = Integer.parseInt(br.readLine());

            answer.append(arr[N][0]).append(" ").append(arr[N][1]).append("\n");
        }
        System.out.println(answer);
    }
}