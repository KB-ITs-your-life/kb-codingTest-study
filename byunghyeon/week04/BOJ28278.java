package week04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ28278 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine()); // 명령 수
        Stack<Integer> stack = new Stack<>();
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            switch (num){
                case 1:
                    int addNum = Integer.parseInt(st.nextToken());
                    stack.add(addNum);
                    break;
                case 2:
                    if(!stack.isEmpty()){
                        answer.append(stack.pop()).append('\n');
                    }else{
                        answer.append(-1).append('\n');
                    }
                    break;
                case 3:
                    answer.append(stack.size()).append('\n');
                    break;
                case 4:
                    answer.append(stack.isEmpty() ? 1 : 0).append('\n');
                    break;
                case 5:
                    if(!stack.isEmpty()){
                        answer.append(stack.peek()).append('\n');
                    }else{
                        answer.append(-1).append('\n');
                    }
                    break;
            }
        }
        System.out.println(answer);

    }
}
