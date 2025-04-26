package week01;

import java.util.*;

public class BOJ1966 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt(); // 테스트 케이스 개수

        while (testCases-- > 0) {
            int n = scanner.nextInt(); // 문서 개수
            int m = scanner.nextInt(); // 찾고 싶은 문서의 위치

            Queue<int[]> queue = new LinkedList<>();
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

            for (int i = 0; i < n; i++) {
                int priority = scanner.nextInt();
                queue.add(new int[]{priority, i}); // (중요도, 원래 위치)
                priorityQueue.add(priority); // 중요도만 저장해서 내림차순 정렬
            }

            int printOrder = 0; // 인쇄 순서

            while (!queue.isEmpty()) {
                int[] current = queue.poll(); // 현재 문서
                if (current[0] == priorityQueue.peek()) { // 가장 높은 중요도면 인쇄
                    priorityQueue.poll(); // 우선순위 큐에서도 제거
                    printOrder++;

                    if (current[1] == m) { // 우리가 찾는 문서라면 출력하고 종료
                        System.out.println(printOrder);
                        break;
                    }
                } else {
                    queue.add(current); // 중요도가 낮으면 다시 큐에 넣음
                }
            }
        }

        scanner.close();
    }
}
