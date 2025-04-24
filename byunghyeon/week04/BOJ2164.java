package week04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ2164 { //카드2
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        N = Integer.parseInt(br.readLine()); // 1~N까지 카드
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 1; i <= N; i++){
            deque.addLast(i);
        }

        // 시작
        while(deque.size() != 1){
            deque.pop(); // 맨 위 카드 버리기
            Integer store = deque.poll(); // 그 다음으로 위에 있는 카드 꺼내서
            deque.addLast(store); // 뒤로 넣기
        }
        System.out.println(deque.pop());
    }
}
