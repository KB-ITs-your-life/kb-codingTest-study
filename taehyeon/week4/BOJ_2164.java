package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Stack;

public class BOJ_2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> cards = new ArrayDeque<>();
        for(int i = 1; i <= N; i++){
            cards.add(i);
        }
        boolean fold=true;

        while(cards.size()>1){
            if (fold){
                fold=false;
                cards.pop();
//                System.out.println("버리고 "+cards);
            } else{
                cards.addLast(cards.pop());
//                System.out.println("추가하고 "+cards);
                fold=true;
            }
        }
        System.out.println(cards.pop());

    }
}
