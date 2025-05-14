import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Number_11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] countCoin = bufferedReader.readLine().split(" ");
        int count = Integer.parseInt(countCoin[0]);
        int coin = Integer.parseInt(countCoin[1]);
        List<Integer> coins = new ArrayList<>();
        for(int i = 0; i < count; ++i) {
            coins.add(Integer.parseInt(bufferedReader.readLine()));
        }
        coins.sort(Collections.reverseOrder());
        int result = 0;
        for(Integer c : coins) {
            result += (coin / c);
            coin %= c;
        }
        System.out.println(result);
    }
}
