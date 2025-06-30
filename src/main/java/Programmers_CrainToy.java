import java.util.Stack;
public class Programmers_CrainToy {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> choose = new Stack<>();
        Stack<Integer> check = new Stack<>();
        int count = 0;

        for(int i=0; i<moves.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[j][moves[i]-1] != 0){
                    choose.push(board[j][moves[i]-1]);
                    board[j][moves[i]-1]=0;
                    break;
                }
            }

        }

        while(!choose.isEmpty()){
            if(check.isEmpty()){
                check.push(choose.pop());
            }
            if(choose.peek() == check.peek()){
                choose.pop();
                check.pop();
                count += 1;
            }else{
                check.push(choose.pop());
            }
        }
        return (count * 2);

    }
}
