package Week1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 문제 해결 */
// i를 증가시켜 문자열로 만들고 666을 포함하고 있을 때마다 카운트를 더함.
// 카운트와 N이 같아지면 증가시키던 수 i를 출력


public class BOJ_1436 {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String num="";
        int n=Integer.parseInt(br.readLine());
        int count=0;
        int i=665;

        while(n!=count){
            i++;
            if(String.valueOf(i).contains("666")){
                count++;
            };
        }
        System.out.println(i);
    }
}
