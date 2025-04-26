package week04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ12789 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        Queue<Integer> line = new LinkedList<>();
        Stack<Integer> tempLine = new Stack<>();
        //  입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            line.add(Integer.parseInt(st.nextToken()));
        }

        int seq = 1;
        while(!line.isEmpty()){
            Integer first = line.peek();
            if(first == seq) {
                line.poll();
                seq++;
                continue;
            }
            if(!tempLine.isEmpty() && tempLine.peek() == seq){
                tempLine.pop();
                seq++;
                continue;
            }


            tempLine.push(line.poll());
        }

        while(!tempLine.isEmpty()){
            if(tempLine.peek() == seq){
                tempLine.pop();
                seq++;
                continue;
            }
            break;
        }

        System.out.println(tempLine.isEmpty() ? "Nice" : "Sad");
    }
}
