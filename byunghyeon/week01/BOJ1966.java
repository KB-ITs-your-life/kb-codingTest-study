package week01;

/*
* BOJ1966 - 프린터 큐
* 자료구조 - 큐, 시뮬레이션, 우선순위
* 담아둔 우선순위들을 내림차순으로 정렬한다.
* 그리고 큐에 있는 것들을 꺼내면서 제일 높은 것이면 리스트에서 제거된다.
* 아니면 큐 뒤에 넣는다.
* 그렇게 큐에서 꺼낸값이 타겟 인덱스와 같으면 그때의 출력순위를 반환한다.
* */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken()); // 테스트 케이스 수

        int doc, findSeq;
        for(int i = 0; i < T; i++){
            st = new StringTokenizer(br.readLine());
            //문서 개수, 순서 궁금한 문서
            doc = Integer.parseInt(st.nextToken());
            findSeq = Integer.parseInt(st.nextToken());

            Queue<Node> queue = new LinkedList<>();
            ArrayList<Integer> priors = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < doc; j++){
                int seq = Integer.parseInt(st.nextToken());
                queue.add(new Node(seq, j));
                priors.add(seq);
            }
            priors.sort(Collections.reverseOrder());

            int rank = 1;
            while(true){
                Node node = queue.poll();
                if(node.prior == priors.get(0)){
                    if(node.originIdx == findSeq) break;
                    priors.remove(0);
                    rank++;
                    continue;
                }
                queue.add(node);
            }
            System.out.println(rank);
        }
    }

    static class Node{
        int prior;
        int originIdx;

        public Node(int prior, int originIdx){
            this.prior = prior;
            this.originIdx = originIdx;
        }
    }
}
