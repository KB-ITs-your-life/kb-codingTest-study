package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/* BFS로 접근해야 할 것 같아
* 하나의 수가 있으면 그 아래에 2를 곱한 것과 1을 오른쪽에 넣은 것을 두고
* depth를 기록하며 계속 내려가는 거지
* 그러다가 두 수가 모두 B보다 커져버리면 -1을 출력하면 되지 않을까?
* 해당 depth에 있는 모든 수가 B보다 커진 것을 어떻게 판별할까?
* 종료 조건 1 : Changing A ==B
* 종료 조건 2 : All of Changing A in depth > B -> -1
*
* 	런타임 에러 (ArrayIndexOutOfBounds)가 떳다 왜 떳을까??
*   cur*10+1이 항상 32bit 범위 안에 있을 것이라는 보장이 없다.
*   java int는 -2,147,483,648에서 2,147,483,647까지
*   A의 범위가 10의 9승까지. 1,000,000,000 까지 이므로
*   뒤에 1을 추가하면 너무 쉽게 넘어버린다.
*   자바의 long 자료형은 -9,223,372,036,854,775,808부터 9,223,372,036,854,775,807까지
*
*
* * */


public class BOJ_16953 {
    static long A;
    static long B;
    static long count=0;
    static long[] cur;

    static boolean []visited;
    static Queue<long[]> queue;

    static void bfs(long start){
    /*
    * 1. QUE에 첫 시작을 넣는다.
    * 2. que가 모두 빌때까지 반복문?? 반복 끝나는건 start==B가 될때 인데,,,?
    * 3. 현재 숫자 cur을 꺼내온다.
    * 3-1. cur == B 면 멈추기.
    * 4. cur을 방문한 적 없으면 cur을 두배 한것과 1을 붙인것을 que에 넣는다.
    * 4-1. cur을 방문으로 만듬
    * 5.
    * */

        cur=new long[]{start,count};
        queue.offer(cur);

        while(!queue.isEmpty()){
            cur = queue.poll();


            if(cur[0]==B){
                count=cur[1];
                break;
            }
            if(!visited[(int)cur[0]]){
                if (cur[0]*2<=B){
                    queue.offer(new long[]{cur[0]*2, cur[1] + 1});
                }
                if(cur[0]*10+1<=B){
                    queue.offer(new long[]{cur[0]*10+1, cur[1] + 1});
                }
            }
            visited[(int)cur[0]]=true;


        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        visited = new boolean[(int)B+1];
        queue=new LinkedList<>();

        bfs(A);
        if(count==0){
            System.out.println(-1);
        } else{
            System.out.println(count+1);
        }

    }
}
