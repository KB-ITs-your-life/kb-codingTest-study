package week03;

/*
* A->B
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16953 {
    static long A, B;
    static int answer = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        // A를 B로 바꾸는데 최소 연산
        bfs16953(A, 1);
        System.out.println(answer);
    }

    private static void bfs16953(long current,int count) {
        if(current > B){
            return;
        }
        if(current == B){
            answer = count;
            return;
        }

        bfs16953(current*2, count+1);
        bfs16953(current*10+1, count+1);

    }
}
