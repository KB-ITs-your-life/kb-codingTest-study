package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1238 {
    static int n;
    static int m;
    static int x;

    static class Node implements Comparable<Node>{
        int start;
        int end;
        int weight;


        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }

        Node(int start,int end, int wegiht ){
            this.start=start;
            this.end = end;
            this.weight = wegiht;
        }
    }

    static ArrayList<Node>[] roads;
    static int[] distGo;
    static int[] distComeback;



    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken()); //마을 개수
        m=Integer.parseInt(st.nextToken()); //도로 개수
        x=Integer.parseInt(st.nextToken()); // 파티 위치


        distGo=new int[n+1];
        distComeback=new int[n+1];

        roads=new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            roads[i]=new ArrayList();
            distGo[i]=Integer.MAX_VALUE;
            distComeback[i]=Integer.MAX_VALUE;
        }


        // 각 마을에서 마을로 가는 root 만들기
        for(int i=1;i<=m;i++){
            st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());
            int weight=Integer.parseInt(st.nextToken());
            roads[start].add(new Node(start,end,weight));
        }
        /*
        0~N번의 마을에서 출발하는 각 학생이 X 마을에서 열리는 파티에 갔다가 오려고 할때
        가장 오래걸리는 학생을 구해라
        X마을에 사는 학생은 구할 필요가 없다.바로 앞에 살기 때문에
        - 그러면 각 지점에서 X로 가는 길을 따로 따로 구해줘야한다?
        - 다시 돌아 올때는 기존 다익스트라 처럼 구현하면 된다.
        - 단방향이기 때문에 갈때랑 올때를 따로 구해야 한다.
        - 갈 때 X에 도달하면 멈춰야 한다
        */
        for(int i=1;i<=n;i++){
            //distGo[i]를 구하는 것. i번째 도시에서 x번째 도시까지 가는 최소거리.

            // 파티마을에서 출발이라면 각 마을까지 얼마나 걸리는 지 확인하는것도? 낫배든가
            if(i==x){
                continue;
            }
            PriorityQueue<Node> pqGo=new PriorityQueue<>();

            // 각 마을마다 x로 가는 거리를 따로 구해야 함.
            int[]tempDist=new int[n+1];

            for(int k=1;k<=n;k++){
                tempDist[k]=Integer.MAX_VALUE;
            }

            tempDist[i]=0;
            pqGo.add(new Node(0,i,0));

            while(!pqGo.isEmpty()){
                Node curNode=pqGo.poll();
                // 만약 현재 위치한 노드가 파티 마을이면
                if(curNode.start==x){
                    // 현재 마을의 거리를 distGo에 넣어 버림.
                    distGo[i]=tempDist[curNode.start];
                    break;
                }
                for(int j=0;j<roads[curNode.end].size();j++){
                    Node nextNode=roads[curNode.end].get(j);
                    if(nextNode.weight+curNode.weight<tempDist[nextNode.end]){
                        tempDist[nextNode.end]=nextNode.weight+curNode.weight;
                        pqGo.add(new Node(nextNode.start, nextNode.end,tempDist[nextNode.end]));
                    }
                }
            }

        }





        // 파티에서 돌아오는 거리 구하기.
        PriorityQueue<Node> pqComeback=new PriorityQueue<>();
        pqComeback.add(new Node(x,0,0));






    }


}






















