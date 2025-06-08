package week10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/*
수업을 시작 시간 기준으로 정렬하면 문제 풀이에 도움이 됩니다. 시작 시간이 같다면 끝나는 시간이 빠른 순으로 정렬하면 더 좋습니다.
우선순위 큐(최소 힙)를 활용하여 현재 사용 중인 강의실 중 가장 빨리 끝나는 강의실의 끝 시간을 관리하면 효율적으로 강의실 개수를 구할 수 있습니다.
새로운 수업의 시작 시간이 우선순위 큐의 최소(가장 빨리 끝나는 강의실의 끝 시간)보다 크거나 같으면 해당 강의실을 재활용할 수 있습니다.
그렇지 않으면 새로운 강의실이 필요합니다.
우선순위 큐의 크기가 곧 필요한 강의실의 최소 개수가 됩니다.
*/

public class BOJ_11000 {
    static class Lec{
        int start;
        int end;
        public Lec(int start, int end){
            this.start = start;
            this.end = end;
        }


    }


    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        StringTokenizer st;
        // 최대 힙 정렬
        PriorityQueue<Lec> pq=new PriorityQueue<>(new Comparator<Lec>(){
            @Override
            public int compare(Lec l1, Lec l2){
                return l1.end-l2.end;
            }
        });
        Lec[] L=new Lec[n];

        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());

            L[i]=new Lec(start,end);

        }
        // 배열 정렬시 시작이 다르다면 시작이 더 빠른게 우선
        // 시작이 같다면 먼저끝나는것이 우선.
        Arrays.sort(L,new Comparator<Lec>(){
            @Override
            public int compare(Lec l1, Lec l2){
                if(l1.start!=l2.start){
                    return l1.start-l2.start;
                }
                return l1.end-l2.end;
            }
        });


        // 정렬된 배열을 순회하면서 가장 먼저 오는 값(우선순위 높은것)을 확인 후 새로 확인한것이 우선권의 끝나는 시간보다 늦게 시작하면
        // poll 한뒤 현재 확인 중인 것으로 바꾸기. 아니면 추가해서 사이즈 ㅁ추가

        for(Lec l:L){
            if(pq.isEmpty()){
                pq.add(l);
                continue;
            }
            Lec earlyEndLec=pq.peek();
            if(earlyEndLec.end<=l.start){
                pq.poll();
            }
            pq.add(l);
        }

        System.out.println(pq.size());



    }

}
