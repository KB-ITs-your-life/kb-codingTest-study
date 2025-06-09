import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // 중요도가 높을수록 빠른 처리
        int testCount = Integer.parseInt(bufferedReader.readLine());
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < testCount; ++i) {
            int[] inputStatus = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            Queue<Priority> queue = new LinkedList<>();
            int[] inputPriority = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for(int j = 0; j < inputStatus[0]; ++j) {
                queue.add(new Priority(j, inputPriority[j]));
            }

            int printOrder = 0;
            while (!queue.isEmpty()) {
                Priority current = queue.poll();
                boolean hasHigherPriority = false;

                for(Priority p : queue) {
                    if(p.priority > current.priority) {
                        hasHigherPriority = true;
                        break;
                    }
                }

                if(hasHigherPriority) {
                    queue.offer(current);
                }
                else {
                    printOrder++;
                    if(current.index == inputStatus[1])  {
                        result.append(printOrder).append('\n');
                        break;
                    }
                }
            }
        }
        System.out.println(result);
    }

    private static class Priority {
        int index;
        int priority;

        public Priority(int index, int priority) {
            this.index = index;
            this.priority = priority;
        }
    }
}
