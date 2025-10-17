package week10;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/*
힙의 [성질]

1. 왼쪽 자식 노드 인덱스 = 부모 노드 인덱스 × 2

2. 오른쪽 자식 노드 인덱스 = 부모 노드 인덱스 × 2 + 1

3. 부모 노드 인덱스 = 자식 노드 인덱스 / 2
힙에서는 '최대 혹은 최소값'을 빠르게 찾기 위한다고 했다.
이를 우선순위가 높은 요소를 빠르게 찾기 위한다고 바꾸어 생각하면 좀 더 편할 것이다.

'부모 노드는 항상 자식 노드보다 우선순위가 높다.'
즉, 모든 요소들을 고려하여 우선순위를 정할 필요 없이 부모 노드는 자식노드보다
 항상 우선순위가 앞선다는 조건만 만족시키며 완전이진트리 형태로 채워나가는 것


* */



public class BOJ_2075 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        PriorityQueue<Integer> heap=new PriorityQueue<>(Collections.reverseOrder());
        StringTokenizer st;

        for(int i=0;i<n;i++)
        {
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                heap.add(Integer.parseInt(st.nextToken()));
            }
        }
        int  ans=0;
        for(int i=0;i<n;i++){

            ans=heap.poll();
        }
        System.out.println(ans);


    }
}


























