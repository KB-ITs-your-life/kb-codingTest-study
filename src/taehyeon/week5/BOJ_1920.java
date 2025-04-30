package taehyeon.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] check = new int[N];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            map.put(Integer.parseInt(st.nextToken()),i);
        }
        int M = Integer.parseInt(br.readLine());
        int[] nums = new int[M];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < M; i++) {
            if(map.containsKey(nums[i])){
                sb.append(1).append("\n");
            } else{
                sb.append(0).append("\n");
            }
        }
        System.out.println(sb);

    }
}
