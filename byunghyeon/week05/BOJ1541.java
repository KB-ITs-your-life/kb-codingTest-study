package week05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ1541 {

    static ArrayList<Integer> numbers = new ArrayList<>();
    static ArrayList<Integer> minusIndex = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < input.length(); i++){
            char ch = input.charAt(i);
            if(ch == '+' || ch == '-'){
                numbers.add(Integer.parseInt(sb.toString()));
                sb.setLength(0);
            }
            sb.append(input.charAt(i));
        }
        numbers.add(Integer.parseInt(sb.toString()));

        int total = 0;
        int number;
        boolean minusMode = false;
        for(int i = 0; i < numbers.size(); i++){
            number = numbers.get(i);
            if(number < 0) {
                total += number;
                minusMode = true;
            }else{
                total += minusMode ? -number : number;
            }
        }

        System.out.println(total);
    }
}