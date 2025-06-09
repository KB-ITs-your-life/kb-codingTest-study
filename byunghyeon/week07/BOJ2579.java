package week06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2579 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[] scores = new int[N];
        for (int i = 0; i < N; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }


        if(N == 1) {
            System.out.println(scores[0]);
            return;
        }
        else if(N == 2){
            System.out.println(scores[0] + scores[1]);
            return;
        }

        int[] answer = new int[N+1];
        answer[0] = 0;
        answer[1] = scores[0];
        answer[2] = scores[0] + scores[1];

        for(int i = 3; i <= N; i++){
            answer[i] = Math.max(answer[i-3] + scores[i-2], answer[i-2]) + scores[i-1];
        }

//        for (int i : answer) {
//            System.out.print(i + " ");
//        }
//        System.out.println();

        System.out.println(answer[N]);
    }
}
