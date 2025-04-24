package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2346 {

    /*
    * 잘못된 풀이 : 같은 수가 들어오면 처리 불가.
    * deque에 넣을 때 Map에도 숫자를 넣고 해당 숫자를 꺼내려햇는데 같은 수는 처리 불가.
    *
    * 어케 풀수 있을까?
    * 숫자를 어케세지 index를 어케,,,가져오지.
    * class를 사용해서 index랑 numValue를 둘 다 가져볼까?
    *
    * */
    static class Balloon{
        int value;
        int index;

        public Balloon(int value, int index){
            this.value = value;
            this.index = index;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb=new StringBuilder();
        HashMap<Integer,Integer> map=new HashMap<>();

        int N = Integer.parseInt(st.nextToken());
        Deque<Balloon> papers = new ArrayDeque <Balloon>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(st.nextToken());
            papers.add(new Balloon(num,i+1));
        }
        sb.append("1 ");
        int moveValue = papers.poll().value; //움직여야할 이동 값

        //인덱스값과 인덱스가 가지고 있는 이동 값을 같이 넣어준다.


        //해당 풍선이 모두 터질때 까지 반복
        while(!papers.isEmpty()){
            //양수일 경우 인덱스가 큰 쪽으로
            if(moveValue > 0){
                //앞에 있는 요소를 모두 뒤로 보낸다.
                for(int i = 1; i < moveValue; i++){
                    papers.add(papers.poll());
                }
                //모두 뒤로 보냈다면
                Balloon next = papers.poll();
                moveValue = next.value; //이동값 갱신
                sb.append(next.index+" "); //터트린 풍선의 위치값 출력 목록에 저장
            }
            //음수일 경우 인덱스가 작은 쪽으로
            else{
                //뒤에 있는 요소들 모두 앞으로 보낸다.
                for(int i = 1; i < -moveValue; i++){
                    papers.addFirst(papers.pollLast());
                }
                //모두 뒤로 보냈다면
                Balloon next = papers.pollLast();
                moveValue = next.value;
                sb.append(next.index+" ");
            }

        }
        System.out.println(sb.toString());
    }
}
