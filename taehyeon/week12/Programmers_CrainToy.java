package week12;

import java.util.*;


public class Programmers_CrainToy {
    public static void main(String[] args) {

    }

    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int length=board.length;

        Stack<Integer> basket=new Stack<>();
        List<Stack<Integer>> game=new ArrayList<>();

        for(int j=0;j<length;j++){
            Stack<Integer> temp=new Stack<>();
            for(int i=length-1;i>=0;i--){
                if(board[i][j]!=0){
                    temp.add(board[i][j]);
                }
            }
            game.add(temp);
            // System.out.println(game);
        }

        for(int move:moves){
            if(game.get(move-1).isEmpty()){
                continue;
            }
            int popNum=game.get(move-1).pop();

            if(basket.isEmpty()){
                basket.push(popNum);
            }else{
                int popNum2=basket.pop();
                if(popNum2==popNum){
                    answer+=2;
                } else{
                    basket.push(popNum2);
                    basket.push(popNum);
                }
            }

        }
        // System.out.println(basket);













        return answer;
    }

}
