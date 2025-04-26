package week02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1992 {
    static int N;
    static int[][] video;
    static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        video = new int[N][N];

        StringTokenizer st;
        for(int i = 0; i < N; i++){
             String row = br.readLine();
            for(int j = 0; j < N; j++){
                video[i][j] = row.charAt(j) - 48;
            }
        }

        compression(N, 0, 0);
        System.out.println(answer);
    }

    private static void compression(int compSize, int startX, int startY) {
        int first = video[startX][startY];
        if(compSize == 1){
            answer.append(first);
            return;
        }

        boolean diff = false;
        for(int i = startX; i < startX + compSize; i++){
            for(int j = startY; j < startY + compSize; j++){
                if(video[i][j] != first){
                    diff = true;
                    break;
                }
            }
            if(diff){
                break;
            }
        }

        if(diff){
            int cutSize = compSize/2;
            answer.append('(');
            compression(cutSize, startX, startY);
            compression(cutSize, startX, startY+cutSize);
            compression(cutSize, startX+cutSize, startY);
            compression(cutSize, startX+cutSize, startY+cutSize);
            answer.append(')');
        }else{
            answer.append(first);
        }

    }
}
