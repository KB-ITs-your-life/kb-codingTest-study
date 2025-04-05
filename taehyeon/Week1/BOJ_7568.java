package Week1;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_7568 {public static void main(String args[]) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N=Integer.parseInt(br.readLine());
    int[][] info=new int[N][2];
    for(int i=0;i<N;i++){
        info[i]=Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }
    // 나보다 키 몸무게 둘다 큰 사람있을 때마다 rank++
    // 근데 키 몸무게 둘 중 하나라도 나보다 작으면 rank 유지
    int[] ranks=new int[N];


    int height=0;
    int weight=0;

    for(int i=0;i<N;i++){
        int rank=1;
        height=info[i][1];
        weight=info[i][0];
        for(int j=0;j<N;j++){
            if(weight<info[j][0] && height<info[j][1]){
                rank++;
            }
        }
        ranks[i]=rank;
    }



    for(int i=0;i<N;i++){
        System.out.printf("%d ",ranks[i]);
    }
}
}
