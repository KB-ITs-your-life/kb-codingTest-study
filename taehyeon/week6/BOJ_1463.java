package week6_7;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*

*/

public class BOJ_1463 {
    static int[] check;
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        check = new int[N+2];

        process(N);

        System.out.println(check[N]);
    }
    public static void process(int n){
        // [1] 기저 사례 초기화
        check[0]=0;
        check[1]=0;

        // [2] Bottom-up 방식으로 2~n까지 계산
        for(int i=2;i<=n;i++){
            if(check[i]==0){
                if(i%6==0){
                    //6으로나누는 이유 : 3과 2 둘다 나눌 수 있을 때 뭐가 더 최소 인지 파악 해야한다.
                    check[i]=Math.min(check[i/3],Math.min(check[i/2],check[i-1]))+1;
                    continue;
                }
                if(i%3==0){
                    check[i]=Math.min(check[i/3],check[i-1])+1;
                    continue;
                }
                if(i%2==0){
                    check[i]=Math.min(check[i/2],check[i-1])+1;
                    continue;
                }
                check[i]=check[i-1]+1;
            }
        }





    }







}
