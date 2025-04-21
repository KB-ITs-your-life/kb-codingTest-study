package week4;

import javax.smartcardio.Card;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_28278 {
    static Stack<Integer> nums = new Stack<Integer>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());

            int M=Integer.parseInt(st.nextToken());

            Stacks stck = new Stacks();
            if(M==1){
                int temp=Integer.parseInt(st.nextToken());
                stck.push(temp);
            } else if(M==2){
                stck.pop();
            }  else if(M==3){
                stck.len();
            } else if(M==4){
                stck.isEmp();
            } else if(M==5){
                stck.top();
            }


        }

    }
    static class Stacks {
        public void push(int num){
            nums.push(num);
        }
        public void pop(){
            if(!nums.isEmpty()){
                System.out.println(nums.pop());
            } else{
                System.out.println(-1);
            }

        }
        public void len(){
            System.out.println(nums.size());
        }
        public void isEmp(){
            if (nums.isEmpty()){
                System.out.println(1);
            } else{
                System.out.println(0);
            }
        }
        public void top(){
            if  (nums.isEmpty()){
                System.out.println(-1);
            } else{
                System.out.println(nums.peek());
            }
        }
    }
}
