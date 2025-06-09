package week05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1449 {
    static int N, L;
    static int[] leaks;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken()); // tape 길이
        leaks = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            leaks[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(leaks);

        int tape = 1;
        int left = L;
        for(int i = 1; i < leaks.length; i++){
            int diff = leaks[i] - leaks[i-1];
            if(diff < left){
                left -= diff;
            }else{
                tape++;
                left = L;
            }
        }
        System.out.println(tape);
    }
}
