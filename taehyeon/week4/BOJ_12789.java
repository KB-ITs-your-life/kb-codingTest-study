package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class BOJ_12789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        //배열인데 양끝에서 데이터를 추가하고 제거할 수 있다.
        //양끝에서 삽입 추출은 시간복잡도가 O(1)이라 사용 <-> LinkedList보다 삽입속도 월등.

        ArrayDeque<Integer> line=new ArrayDeque<>();
        ArrayDeque<Integer> space=new ArrayDeque<>();


        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(st.nextToken());
            line.add(num);
        }
        /*
        * 이건 또 어떻게 푸냐
        * 문제 설명 : 학생들이 서있는데 섞여있다. 얘네가 순서대로 간식을 받아야 나도 받는다.
        * 근데 옆에 잠깐 비켜설수있는공간이 있다. 여기로 갈순있어도 다시 출발지로는 못옴.
        * 1. 시작 줄에서 poll해서 순서가 아니면 space에 보내둔다.
        * 1-1. 순서면 반복문 진행
        * 2. 맨첨 시작할때 space 마지막이 지금 순서가 맞는지 확인해야함
        * 3. 만약 line다 나왔는데 순서가 맞지않으면 Sad 출력
        *
        * */

        int cur=1;
        boolean flag=true;

        while(cur<N){
//            System.out.println("현재 확인하는것 : "+cur);
            int temp=0;
            if(!space.isEmpty()){
                temp = space.peek();
            }
            if(temp==cur){
                space.pop();
                cur++;
                continue;
            }
            while(!line.isEmpty()){
                temp=line.poll();
                if(temp!=cur){
                    space.push(temp);
//                    System.out.println(space);
                } else{
                    break;
                }
            }
            if(temp==cur){
                cur++;
                continue;
            } else{
                flag=false;
//                System.out.println("실패");
                break;
            }





        }
        if(flag){
            System.out.println("Nice");
        }else{
            System.out.println("Sad");
        }



    }
}
