import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10974 {
    static int size;
    static int[] save;
    static boolean[] used;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(bufferedReader.readLine());
        save = new int[size];
        used = new boolean[size + 1];

        backtrack(0);
    }

    private static void backtrack(int depth) {
        if(depth == size) {
            for(int i = 0; i < size; ++i) {
                System.out.print((save[i] + " "));
            }
            System.out.println();
            return;
        }

        for(int num = 1; num <= size; ++num) {
            if(!used[num]) {
                used[num] = true;
                save[depth] = num;
                backtrack(depth + 1);
                used[num] = false;
            }
        }
    }
}
