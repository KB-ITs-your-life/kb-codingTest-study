import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Number_2164 {
    public static void main(String[] args) throws IOException {
        System.out.println(move(readNumber()));
    }

    private static int readNumber() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        return Integer.parseInt(bufferedReader.readLine());
    }

    private static int move(int number) {
        List<Integer> cards = new LinkedList<>();
        for(int i = 1; i <= number; ++i) {
            cards.add(i);
        }
        while(cards.size() > 1) {
            cards.remove(0);
            cards.add(cards.size() - 1, cards.remove(0));
        }
        return cards.get(0);
    }
}
