package week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ2961 {
    static int N;
    static int S,B;
    static boolean[] isVisited;
    static ArrayList<Ingradient> ingradients;
    static int min = 999999999;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        isVisited = new boolean[N];

        ingradients = new ArrayList<>();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken()); // 신맛(곱)
            B = Integer.parseInt(st.nextToken()); // 쓴맛(합)
            ingradients.add(new Ingradient(B, S));
        }

        diffTaste(0, 0 ,1);
        System.out.println(min);
    }

    private static void diffTaste(int stage, int bits, int sours) {
        if(stage > N){
            return;
        }

        for(int i = 0; i < N; i++){
            if(!isVisited[i]){
                isVisited[i] = true;
                Ingradient ingradient = ingradients.get(i);
                int bitSum = bits+ingradient.bit;
                int sourMul = sours*ingradient.sour;
                int diff = bitSum > sourMul ? bitSum - sourMul : sourMul - bitSum;
                min = Math.min(min, diff);
                diffTaste(stage+1, bitSum, sourMul);
                isVisited[i] = false;
            }
        }

    }

    static class Ingradient{
        int bit;
        int sour;
        public Ingradient(int bit, int sour){
            this.bit = bit;
            this.sour = sour;
        }

    }

}
