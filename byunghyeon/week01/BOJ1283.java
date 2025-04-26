package week01;

// 다시 풀기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ1283 {

    static ArrayList<Character> cuts = new ArrayList<>();
    static StringBuilder shortcuts = new StringBuilder();
    static ArrayList<String> inputs = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            inputs.add(br.readLine());
        }

        for(int i = 0; i < N; i++){
            String input = inputs.get(i);
            StringTokenizer st = new StringTokenizer(input);
            StringBuilder sb = new StringBuilder();
            boolean isFail = true;

            while(st.hasMoreTokens()){
                String token = st.nextToken();
                String result = token;
                char out = token.charAt(0);
                if(!cuts.contains(out) && isFail){
                    cuts.add(Character.toLowerCase(out));
                    cuts.add(Character.toUpperCase(out));
                    result = "[" + out + "]" + token.substring(1);
                    isFail = false;
                }

                sb.append(result).append(' ');
            }

            if(isFail){
                sb.setLength(0);
                String string = null;
                for(int j = 0; j < input.length(); j++){
                    char out = input.charAt(j);
                    if(out == ' ') continue;
                    int idx = input.indexOf(out);
                    if(!cuts.contains(out)){
                        cuts.add(Character.toLowerCase(out));
                        cuts.add(Character.toUpperCase(out));
                        string = input.substring(0,idx) + "[" + out + "]" + input.substring(idx+1);
                        break;
                    }
                }
                sb.append(string).append(' ');
            }

            if(sb.substring(0,4).equals("null")){
                sb.setLength(0);
                sb.append(input);
            }

            sb.append('\n');
            shortcuts.append(sb);
        }
        System.out.println(shortcuts);

    }
}
