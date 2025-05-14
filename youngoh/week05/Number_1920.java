import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class Number_1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int countN = Integer.parseInt(bufferedReader.readLine());
        Set<Integer> N = new LinkedHashSet<>();
        String[] rawNumberN = bufferedReader.readLine().split(" ");
        for(int i = 0; i < countN; ++i) {
            N.add(Integer.parseInt(rawNumberN[i]));
        }

        StringBuilder result = new StringBuilder();

        int countM = Integer.parseInt(bufferedReader.readLine());
        String[] rawNumberM = bufferedReader.readLine().split(" ");
        for(int i = 0; i < countM; ++i) {
            if(N.contains(Integer.parseInt(rawNumberM[i]))) {
                result.append("1").append('\n');
            }
            else {
                result.append("0").append('\n');
            }
        }

        System.out.println(result);
    }
}
