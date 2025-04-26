package week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BOJ9095 {
    static int N;
    static Set<String> store = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            N = Integer.parseInt(br.readLine());
            int[] numArr = new int[N];
            Arrays.fill(numArr, 1);

            makeSum(numArr, 0);

            System.out.println(store.size()+1);
            store.clear();
        }
    }

    private static void makeSum(int[] numArr, int start) {

        if(start == N-1){
            return;
        }

        for(int i = start+1; i < N; i++){

            int sum = numArr[i] + numArr[start];

            if(sum > 3) continue;

            numArr[i] = sum;

            StringBuilder numCase = new StringBuilder();
            for (int j = i; j < N; j++) {
                numCase.append(numArr[j]).append(' ');
            }
            store.add(numCase.toString());

            makeSum(Arrays.copyOf(numArr, numArr.length), start+1);
            numArr[i] -= numArr[start];
        }
    }
}
