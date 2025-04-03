package Week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 그리디 알고리즘
현재 상태에서 볼 수 있는 선택지 중에 최선의 선택을 하는 것.
DP보다 구현이 쉽고 시간 복잡도가 우수함. 그러나 항상 최적해 보장 X
1. 해 선택 : 현재 상태에서 가장 최선이라고 생각되는 해를 선택
2. 적절성 검사 : 현재 선택 해가 전체 문제의 제약 조건에 벗어나지 않는지 검사
3. 해 검사 : 현재까지 선택한 해 집합이 전체 문제를 해결할 수 있는지 검사.
전체 문제 해결 못하면 1로 돌아가 반복
*/

/* 문제설명 : 0으로 차있는 n개짜리 배열 a를 배열 b처럼 만드려면 어떻게 해야하나?
 - 배열의 값 하나를 1 증가 가능 / 모든 배열의 수를 2배 가능.
 최소 연산 수 를 구하라.

 ** 해결 방법**
    arrB가 arrA가 되도록 노력하는 것이 좋지 않을까,,?
   힌트 : 배열 원소마다 순회하며 짝수면 2로 나누고 홀수면 1뺀다.
   - 1뺄때는 count 바로 1 증가
   - 2로 나누는 것은 한 번 순회에서 한번이라도 있어도 count 증가,,?





 */



public class BOJ_12931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        int[] arrA=new int[n];
        int[] arrB=new int[n];
        String[] input=br.readLine().split(" ");

        for(int i=0;i<n;i++){
            arrB[i]=Integer.parseInt(input[i]);
        }

    }

}
