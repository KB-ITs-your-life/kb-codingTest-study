package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_4779 {
    static char[] dash;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb;

        String input;

        while((input = br.readLine()) != null){
            int n = Integer.parseInt(input);
            sb = new StringBuffer();

            int size=1;
            for(int i=0;i<n;i++){
                size*=3;
            }


            dash=new char[size];
            Arrays.fill(dash,'-');


            Dash(0, size);
            for(int i=0;i<dash.length;i++){
                sb.append(dash[i]);
            }
            System.out.println(sb);
        }
        br.close();


    }
    private static void Dash(int start,int size){
        if(size<=1) {
            return;
        }

        int reSize=size/3;
        for(int i=reSize+start;i<start+(reSize*2);i++){
            dash[i]=' ';
        }
        Dash(start,reSize);
        Dash(start+(reSize*2),reSize);

    }
}
