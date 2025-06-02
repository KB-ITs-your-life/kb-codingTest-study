package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    N개의 노드로 이루어진 트리가 주어지고 M개의 두 노드 쌍을 입력받을 때 두 노드 사이의 거리를 출력하라.

*/
public class BOJ_1240 {
    static int n;
    static int m;

    static class Pair{
        int node;
        int dist;
        public Pair(int node, int dist){
            this.node = node;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        /*
            노드가 n개 잖아.
        */
        List<List<Pair>> nodes= new ArrayList<>();
        for(int i=0;i<=n;i++){
            nodes.add(new ArrayList<>());
        }

        for(int i=1;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());
            nodes.get(a).add(new Pair(b,c));
            nodes.get(b).add(new Pair(a,c));

        }
        System.out.println();
        for(int i=1;i<=n;i++){
            ;for (Pair p : nodes.get(i)) {
                System.out.print(i+"번쨰 "+"(" + p.node + "," + p.dist + ") ");
            }

        }

        // 알고 싶은 두 점 입력 받기.
        for(int j=1;j<=m;j++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            System.out.println(getDistance(a,b));


        }





    }
    static int getDistance(int a,int b){
        int distance=0;







        return distance;
    }

}





















