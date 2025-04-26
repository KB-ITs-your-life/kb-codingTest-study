package week4;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2167 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());

        int[][]  matrix=new int[N+1][M+1];
        int[][]  matrix_sum=new int[N+1][M+1];

        for(int i=1; i<=N; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++){
                int num=Integer.parseInt(st.nextToken());
                matrix[i][j]=num;

                matrix_sum[i][j]=matrix_sum[i-1][j]+matrix_sum[i][j-1]-matrix_sum[i-1][j-1]+num;
//                System.out.println(matrix[i][j]);
            }
        }
//        for(int i=1; i<=N; i++){
//            for(int j=1; j<=M; j++){
//                System.out.print(matrix[i][j]+" ");
//            }
//            System.out.println();
//        }
        st=new StringTokenizer(br.readLine());
        int k=Integer.parseInt(st.nextToken());
        for(int i=1; i<=k; i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());

            System.out.println(matrix_sum[x][y]-matrix_sum[x][b-1]-matrix_sum[a-1][y]+matrix_sum[a-1][b-1]);
        }


    }
}
