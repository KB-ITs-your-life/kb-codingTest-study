package week05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2512 {
    static int N;
    static int[] budgets;
    static int totalBudgets;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        budgets = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            budgets[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(budgets);
        totalBudgets = Integer.parseInt(br.readLine());

        int start = 1;
        int end = budgets[budgets.length-1];
        int mid;
        int budget;
        int answer = -1;
        while(start <= end){
            budget = 0;
            mid = (start + end) / 2;
            for(int i = 0; i < N; i++){
                if(mid > budgets[i])
                    budget += budgets[i];
                else
                    budget += mid; // 이걸 최대로 해야함
            }

            if(budget <= totalBudgets){
                answer = mid;
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        System.out.println(answer);
    }
}
