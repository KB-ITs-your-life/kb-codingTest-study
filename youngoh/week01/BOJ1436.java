import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(bufferedReader.readLine());
        int sequence = 0;
        int number = 665;
        while(input != sequence) {
            number++;
            if(String.valueOf(number).contains("666")) {
                sequence++;
            }
        }
        System.out.println(number);
    }
}
