package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ11286 implements Comparator<Integer> {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new BOJ11286());
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < N; i++){
            int x = Integer.parseInt(br.readLine());
            if(x == 0){
                answer.append(priorityQueue.isEmpty() ? 0 : priorityQueue.poll()).append("\n");
                continue;
            }
            priorityQueue.add(x);
        }

        System.out.print(answer);
    }

    @Override
    public int compare(Integer a, Integer b) {
        int absCompare = Integer.compare(Math.abs(a), Math.abs(b));
        if (absCompare == 0) {
            // 절대값이 같으면 원래 값 비교 (예: -2, 2 → -2가 먼저)
            return Integer.compare(a, b);
        }
        return absCompare;
    }
}
