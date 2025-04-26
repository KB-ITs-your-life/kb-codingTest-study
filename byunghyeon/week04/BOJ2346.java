package week04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ2346 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 입력
        N = Integer.parseInt(br.readLine());
        Deque<Ballon> deque = new ArrayDeque<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++){
            int move = Integer.parseInt(st.nextToken());
            deque.addLast(new Ballon(i, move));
        }

        StringBuilder answer = new StringBuilder();
        while(true){
            Ballon firstGet = deque.removeFirst();
            answer.append(firstGet.number).append(' ');
            if(deque.isEmpty()) break;

            if(firstGet.move > 0){
                for(int i = 0; i < firstGet.move-1; i++){
                    deque.addLast(deque.removeFirst());
                }
                continue;
            }

            if(firstGet.move < 0){
                int move = (-firstGet.move);
                for(int i = 0; i < move; i++){
                    deque.addFirst(deque.removeLast());
                }
            }
        }
        System.out.println(answer);

    }

    static class Ballon{
        int number;
        int move;
        public Ballon(int number, int move){
            this.number = number;
            this.move = move;
        }
    }
}
