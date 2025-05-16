package week06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ15486 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        // 시간 및 이익 입력
        ArrayList<Consulting> consultings = new ArrayList<>();
        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());// 상담 완료 기간
            int P = Integer.parseInt(st.nextToken());// 상담 시 받을 수 있는 금액
            consultings.add(new Consulting(T, P));
        }

        // 얻을 수 있는 최대 이익 찾기
        List<Integer> accs = new ArrayList<>();
        for(int i = 0; i < N+1; i++){
            accs.add(0);
        }

        int consultEnd;
        for(int i = 1; i <= N; i++){
            Consulting consulting = consultings.get(i-1);

            if(accs.get(i) < accs.get(i-1))
                accs.set(i, Math.max(accs.get(i), accs.get(i-1)));

            consultEnd = consulting.T + i - 1;
            if(consultEnd <= N){
                accs.set(consultEnd, Math.max(consulting.P + accs.get(i-1), accs.get(consultEnd)));
            }
        }

        System.out.println(Collections.max(accs));
    }

    static class Consulting{
        int T;
        int P;

        public Consulting(int t, int p) {
            T = t;
            P = p;
        }
    }
}
