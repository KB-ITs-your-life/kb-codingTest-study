package week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_10026 {
    static int n;
    static char[][] area;
    static char[][] area_forRG;
    static boolean[][] visited;
    static boolean[][] visitedForRG;
    static int noRG=0;
    static int yesRG=0;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(br.readLine());
        area=new char[n][n];
        area_forRG=new char[n][n];
        visited=new boolean[n][n];
        visitedForRG=new boolean[n][n];


        for(int i=0;i<n;i++){
            String temp=br.readLine();
            for(int j=0;j<n;j++){
                area[i][j]=temp.charAt(j);

                if(temp.charAt(j)=='R'){
                    area_forRG[i][j]='G';
                    continue;
                }
                area_forRG[i][j]=temp.charAt(j);
            }
        }


        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j]){
                    forNoRG(i,j);
                    noRG++;
                }

            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(!visitedForRG[i][j]){
                    forYesRG(i,j);
                    yesRG++;
                }

            }
        }


        System.out.println(noRG+" "+yesRG);




//        for(int j=0;j<n;j++){
//            for(int i=0;i<n;i++){
//                System.out.print(area_forRG[i][j]+" ");
//            }
//            System.out.println();
//        }



    }
    static public void forNoRG(int r,int c){

        char nowColor=area[r][c];

        ArrayDeque<int[]> queue=new ArrayDeque<>();
        queue.offer(new int[]{r,c});
        visited[r][c]=true;

        while(!queue.isEmpty()){
            int[] curr=queue.poll();
            for(int i=0;i<4;i++){
                int nextC=curr[1]+dc[i];
                int nextR=curr[0]+dr[i];

                if(nextR>=0 &&  nextR<n && nextC>=0 && nextC<n){
                    if(!visited[nextR][nextC] && area[nextR][nextC]==nowColor){
                        visited[nextR][nextC]=true;
                        queue.offer(new int[]{nextR,nextC});

                    }
                }
            }

        }





    }
    static public void forYesRG(int r,int c){
        char nowColor=area_forRG[r][c];


        ArrayDeque<int[]> queue=new ArrayDeque<>();
        queue.offer(new int[]{r,c});
        visitedForRG[r][c]=true;

        while(!queue.isEmpty()){
            int[] curr=queue.poll();
            for(int i=0;i<4;i++){
                int nextC=curr[1]+dc[i];
                int nextR=curr[0]+dr[i];

                if(nextR>=0 &&  nextR<n && nextC>=0 && nextC<n){
                    if(!visitedForRG[nextR][nextC] && area_forRG[nextR][nextC]==nowColor){
                        visitedForRG[nextR][nextC]=true;
                        queue.offer(new int[]{nextR,nextC});

                    }
                }
            }

        }

    }

}
