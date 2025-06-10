package week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1753 {
    static class Dijkstra implements Comparable<Dijkstra>{
        int to;
        int weight;
        public Dijkstra(int to, int weight){
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Dijkstra d){
            return weight - d.weight;
        }

    }

    static ArrayList<Dijkstra>[]arr;
    static boolean[] visited;
    static int[] dist;
    static int N;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int V=Integer.parseInt(st.nextToken());
        int E=Integer.parseInt(st.nextToken());

        st=new StringTokenizer(br.readLine());
        int start=Integer.parseInt(st.nextToken());

        arr=new ArrayList[V+1];
        dist=new int[V+1];

        for(int i=1;i<=V;i++){
            arr[i]=new ArrayList();
        }
        for(int i=1;i<=V;i++){
            dist[i]=Integer.MAX_VALUE;
        }


        for(int i=0;i<E;i++){
            st=new StringTokenizer(br.readLine());
            int from=Integer.parseInt(st.nextToken());
            int to=Integer.parseInt(st.nextToken());
            int weight=Integer.parseInt(st.nextToken());
            arr[from].add(new Dijkstra(to,weight));


        }
//        for(int i=1;i<=V;i++){
//            System.out.printf("%d번째 ",i);
//            System.out.println();
//            for(Dijkstra d:arr[i]){
//                System.out.println(d.from+" "+d.to+" "+d.weight);
//            }
//        }


        dist[start]=0;

        PriorityQueue<Dijkstra> pq=new PriorityQueue<>();
        pq.offer(new Dijkstra(start,0));
        while(!pq.isEmpty()){
            Dijkstra curVertex=pq.poll();
            for(int i=0;i<arr[curVertex.to].size();i++){
                Dijkstra nextVertex=arr[curVertex.to].get(i);
                if(nextVertex.weight+curVertex.weight <dist[nextVertex.to]){
                    dist[nextVertex.to]=nextVertex.weight+curVertex.weight;
                    pq.add(new Dijkstra(nextVertex.to,dist[nextVertex.to]));
                }
            }






        }
        for(int i=1;i<=V;i++){
            if(dist[i]!=Integer.MAX_VALUE){
                System.out.println(dist[i]);
            } else{
                System.out.println("INF");
            }

        }






















    }
}
