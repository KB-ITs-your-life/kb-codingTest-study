package yeonhoo.week04;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CT_2164 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        // <> 제네릭 : LinkedList에 Integer 타입의 데이터를 지정
        // LinkedList를 사용하기 위해서는 상단에 패키지를 명시하여 가져와야 한다.
        // Queue도 마찬가지
        int answer = 0;

        for (int i=1; i<=N; i++) {
            queue.add(i);
        }

        while(queue.size() > 0) {
            if(queue.size() == 1) {
                answer = queue.poll();
                break;
            }
            else {
                queue.poll();
            }
            if(queue.size() >0) {
                queue.add(queue.poll());
            }
        }
        System.out.println(answer);
    }
}