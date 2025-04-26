package week03;

import java.util.Scanner;
import java.util.Stack;

public class BOJ9012 {
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int N = sc.nextInt();

       for (int i = 0; i < N; i++) {
           String str = sc.next();
           if(isVPS(str)){
               System.out.println("YES");
           } else{
               System.out.println("NO");
           }
       }
   }

   public static boolean isVPS(String str){
       Stack<Character> stack = new Stack<>();

       for (int i = 0; i < str.length(); i++) {
           char ch = str.charAt(i);

           if(ch=='('){
               stack.push(ch);
           } else if (ch==')'){
               if(stack.isEmpty()){
                   return false;
               }
               stack.pop();
           }
       }
       return stack.isEmpty();
   }
}
