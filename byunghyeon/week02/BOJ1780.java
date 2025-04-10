package week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1780 {

    static int[][] table;
    static int N;

    static int[] answer = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        table = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        findPaperNum(N, 0,0);

        for(int i = 0; i < 3; i++){
            System.out.println(answer[i]);
        }
    }

    private static void findPaperNum(int paperSize, int startX, int startY) {

        int first = table[startX][startY];
        if(paperSize == 1){
            answer[first+1]++;
            return;
        }

        boolean isDiff = false;
        int xSize = startX + paperSize;
        int ySize = startY + paperSize;
        for(int i = startX; i < xSize; i++){
            for(int j = startY; j < ySize; j++){
                if(first != table[i][j]){
                    isDiff = true;
                    break;
                }
            }

            if(isDiff) break;
        }



        if(isDiff){
            int size = paperSize/3;
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    findPaperNum(size, startX+size*i, startY+size*j);
                }
            }
        }else{
            answer[first+1]++;
        }


    }
}
