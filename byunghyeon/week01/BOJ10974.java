package week01;

/*
* BOJ10974 - 모든 순열
* 알고리즘 - 백트래킹(재귀)
*
* isVisited는 각 번호가 쓰였는지 안 쓰였는지 체크하는 용도.
* 백트래킹(재귀)를 통해서 순열을 구했다.
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10974 {

    static boolean[] isVisited;
    static int N;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        isVisited = new boolean[N+1];
        print(1, answer);
    }

    public static void print(int stage, StringBuilder answer) {

        if(stage > N) {
            System.out.println(answer);
            return;
        }

        for(int i = 1; i <=N; i++){

            if(!isVisited[i]){
                isVisited[i] = true;
                answer.append(i).append(" ");
                print(stage+1, answer);
                answer.setLength(answer.length()-2);
                isVisited[i] = false;
            }
        }
    }
}
