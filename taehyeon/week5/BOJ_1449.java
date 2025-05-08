package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/*   그리디 알고리즘 문제 풀이 순서
     1. 선택 절차 : 현재 상태에서 최적인 선택을 한다.
     2. 적절성 검사 : 선택한 항목이 문제의 조건을 만족시키는지 확인
     3. 해답 검사 : 모든 선택이 완료되면 최종 선택이 문제 조건 만족시키는지 확인.
* */

public class BOJ_1449 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        int l=Integer.parseInt(st.nextToken());

        st=new StringTokenizer(br.readLine());
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        /*
        * 그리디인만큼 가장 최적의 해가 구해지는 경우의 수를 생각해야한다.
        * 물이 새는 위치의 차이를 토대로.
        * 1. 파이프 가장 앞에서 부터 검사
        * 2. 구멍 - 0.5와 다음 구멍 + 0.5가 L보다 작으면 선택
        * */






    }
}
