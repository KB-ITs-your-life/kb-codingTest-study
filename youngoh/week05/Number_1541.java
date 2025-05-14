import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Number_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        int sum = 0;
        String[] splitedString = input.split("-");
        for(String number : splitedString[0].split("\\+")) {
            sum += Integer.parseInt(number);
        }

        for(int i = 1; i < splitedString.length; ++i) {
            for(String number : splitedString[i].split("\\+")) {
                sum -= Integer.parseInt(number);
            }
        }

        System.out.println(sum);
    }
}
