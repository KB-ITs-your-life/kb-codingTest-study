package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class BOJ_2961 {
    static int N;
    static int S,B;
    static boolean []visited;
    static ArrayList<Ingredient> ingredient;
    static int mins=99999999;

    static class Ingredient{
        int sour;
        int bitter;

        Ingredient(int sour,int bitter) {
            this.sour = sour;
            this.bitter = bitter;
        }
    }


    public static void main(String args[]) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken()); //재료 개수

        visited=new boolean[N];
        ingredient=new ArrayList<Ingredient>();

        /*
        * 그 음식의 신맛은 사용한 재료의 신맛의 곱이고, 쓴맛은 합
        * 재료는 적어도 하나 사용
        * 신맛과 쓴맛의 차이가 가장 작게 나오는 음식을 구하시오
        * */


        for(int i=0;i<N;i++){  //재료의 신맛과 쓴맛 입력받기
            st=new StringTokenizer(br.readLine());

            S=Integer.parseInt(st.nextToken());
            B=Integer.parseInt(st.nextToken());
            ingredient.add(new Ingredient(S,B));
        }
        /*
        * 모든 경우의 수를 계산하는 것은 좀 에반데
        * min을 정의해두고 반복문을 순회하면서 비교?
        *  -> 1,3,4로 해도 되잖아
        * 신맛이 가장 큰 것 부터 하면 되지않을까? 신맛은 곱이고 쓴맛은 합이니
        * 신맛대로 정렬했을 때 쓴맛의 순서차이때문에 문제가 생김.
        * 쓴맛도 신맛도 클때만 뒤로 보낸다. 아니래
        *
        * 이것도 백트래킹을 쓰라고??
        * 모든 조합을 확인해봐야 하니까 그렇구나 모든 조합ㅇ 확인하는 거면 백트래킹인듯
        * 백트래킹을 쓰면서 모든 조합을 확인하고 min보다 작은게 나올 때마다 min을 교체?
        *
        * 백트래킹 backtrack(recur, 신맛곱, 짠맛합)
        */
        backtrack(0,1,0);
        System.out.println(mins);

    }
    private static void backtrack(int recur,int sourMul,int bitSum){
        if(recur>N){
            return;
        }
        for(int i=0;i<N;i++){
            if(!visited[i]){
                visited[i]=true;
                int sours=sourMul*ingredient.get(i).sour;
                int bits=bitSum+ingredient.get(i).bitter;
                int dif=bits>sours ? bits-sours:sours-bits;
                mins=Math.min(mins,dif);
                backtrack(recur+1,sours,bits);
                visited[i]=false;
            }
        }
    }

}

























