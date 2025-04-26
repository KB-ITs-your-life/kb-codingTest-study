package week05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1920 {
    static int N, M;
    static int[] A;
    static int[] Goal;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        StringBuilder answer = new StringBuilder();
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            int target = Integer.parseInt(st.nextToken());
            answer.append(binarySearch(0, N-1, target)).append("\n");
        }
        System.out.println(answer);
    }

    public static int binarySearch(int start, int end, int target){
        // 1 2 3 4 5
        // 1 3 5 7 9
        if(start > end)
            return 0;

        int mid = (start + end) / 2;

        if(A[mid] > target){
            return binarySearch(0, mid-1, target);
        }else if(A[mid] < target){
            return binarySearch(mid+1, end, target);
        }else{
            return 1;
        }
    }
}
