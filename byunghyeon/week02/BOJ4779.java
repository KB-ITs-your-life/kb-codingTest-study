package week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ4779 {
    static int N;
    static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = "";
        while((input=br.readLine())!=null && !(input.isEmpty())) {
            N = Integer.parseInt(input);
            int num = (int)Math.pow(3, N);
            printCantor(num);
            answer.append("\n");
        }
        System.out.println(answer);
    }

    private static void printCantor(int M) {
        if(M == 1){
            answer.append("-");
            return;
        }

        int div = M/3;
        printCantor(div);
        for(int i = 0; i < div; i++){
            answer.append(" ");
        }
        printCantor(div);

    }
}
