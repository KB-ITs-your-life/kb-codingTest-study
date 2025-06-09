import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class BOJ1283 {
    static List<Character> alphabets = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(bufferedReader.readLine());
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < count; ++i) {
            String input = bufferedReader.readLine();
            result.append(getShortcutKey(alphabets, input)).append('\n');
        }
        System.out.println(result);
    }

    private static String getShortcutKey(List<Character> alphabets, String input) {
        StringBuilder result = new StringBuilder();
        if(input.contains(" ")) {
            String[] splitedString = input.split(" ");
            boolean isShortcut = false;
            for(int i = 0; i < splitedString.length; ++i) {
                if (!alphabets.contains(Character.toLowerCase(splitedString[i].charAt(0)))) {
                    alphabets.add(Character.toLowerCase(splitedString[i].charAt(0)));
                    String word = splitedString[i];
                    StringBuilder sb = new StringBuilder(word);
                    sb.insert(0, '[');
                    sb.insert(2, ']');
                    splitedString[i] = sb.toString();
                    isShortcut = true;
                    break;
                }
            }
            if(!isShortcut) {
                OuterLoop:
                for(int i = 0; i < splitedString.length; ++i) {
                    for(int j = 1; j < splitedString[i].length(); ++j) {
                        if (!alphabets.contains(Character.toLowerCase(splitedString[i].charAt(j)))) {
                            alphabets.add(Character.toLowerCase(splitedString[i].charAt(j)));
                            String word = splitedString[i];
                            StringBuilder sb = new StringBuilder(word);
                            sb.insert(j, '[');
                            sb.insert(j + 2, ']');
                            splitedString[i] = sb.toString();
                            break OuterLoop;
                        }
                    }
                }
            }
            for (String s : splitedString) {
                result.append(s).append(" ");
            }

            return result.toString();
        }
        for(int i = 0; i < input.length(); ++i) {
            if(!alphabets.contains(Character.toLowerCase(input.charAt(i)))) {
                alphabets.add(Character.toLowerCase(input.charAt(i)));
                StringBuilder sb = new StringBuilder(input);
                sb.insert(i, '[');
                sb.insert(i + 2, ']');
                return sb.toString();
            }
        }
        return input;
    }
}
