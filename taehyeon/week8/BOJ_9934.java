package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_9934 {
    static int[] building;
    static List<Integer>[] tree;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int nodeCount=1;
        for(int i=1;i<=k;i++){
            nodeCount*=2;
        }
        nodeCount-=1;
        building=new int[nodeCount+1];
        tree=new ArrayList[k];
        for(int i=0;i<k;i++){
            tree[i]=new ArrayList<>();
        }

        StringTokenizer st=new StringTokenizer(br.readLine());


        for(int i=1;i<=nodeCount;i++){
            building[i]=Integer.parseInt(st.nextToken());
        }


        /*
        1 2 3 4 5 6 7
        1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
        1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31
        */


        // root 출력

        bfs(1,nodeCount,0);

        for(int i=0;i<k;i++){
            for(int index:tree[i]){
                System.out.print(index+" ");
            }
            System.out.println();
        }



    }
    static void bfs(int start,int end,int depth){
        if(start>end){
            return;
        }
        int mid=(start+end)/2;

        tree[depth].add(building[mid]);
        bfs(start,mid-1,depth+1);
        bfs(mid+1,end,depth+1);






    }
}





















