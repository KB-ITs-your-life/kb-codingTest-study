package week6;

import java.io.*;
import java.util.*;

/* 1. DP 핵심 개념
중복 부분 문제: 동일한 계산이 반복되는 문제 (예: 피보나치 수열)
최적 부분 구조: 큰 문제의 최적해가 작은 문제의 최적해로 구성되는 성질 (예: 최단 경로)

 * */

public class BOJ_9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //스티커를 2차원으로 받아야하나? 인덱스랑 값을 같이,,,,받?
        HashMap<Integer,Integer> sticker1 = new HashMap<>();
        HashMap<Integer,Integer> sticker2 = new HashMap<>();
        HashMap[] stickers = new HashMap[2];

        int T=Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            //스티커 입력받기
            int n=Integer.parseInt(br.readLine());

            st=new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++){
                sticker1.put(i,Integer.parseInt(st.nextToken()));
            }


            stickers[0]=sticker1;

            st=new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++){
                sticker2.put(i,Integer.parseInt(st.nextToken()));
            }
            stickers[1]=sticker2;

            int sum=0;

            // 풀이.
            // 특정 n에서 위아래 중 큰 점수 선택했을 때.??
            //









        }

    }
}
