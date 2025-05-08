package week06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ1463_BFS {
    static int N;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        bfs1463();
        System.out.println(answer);
    }

    private static void bfs1463() {
        Queue<X> queue = new LinkedList<>();

        queue.add(new X(N,0));
        while(!queue.isEmpty()){
            X n = queue.poll();

            if(n.num == 1){
                answer = n.depth;
                return;
            }

            if(n.num % 3 == 0){
                queue.add(new X(n.num/3, n.depth + 1));
            }
            if(n.num % 2 == 0){
                queue.add(new X(n.num/2, n.depth + 1));
            }
            queue.add(new X(n.num - 1, n.depth + 1));
        }
    }
    static class X{
        int num;
        int depth;

        public X(int num, int depth) {
            this.num = num;
            this.depth = depth;
        }
    }
}
//10,000,000 < 2^24
//int 256 => 1Kb
//int 1024x8192 => 128Mb
//1500만 연산 이내
