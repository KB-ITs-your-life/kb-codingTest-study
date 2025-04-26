package week01;

/*
* BOJ1436 - 영화감독 숌
* 알고리즘 - 브루트포스
* 숫자를 1씩 늘리며 문자열로 변환한 후 666이 들어가는지 비교한다.
* 666이 들어가면 count를 증가시키며 N번째 영화의 제목이 들어간 수를 출력한다.
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // N번째 영화의 제목에 들어간 수


        int count = 0;
        Integer start = 666;

        while(true) {
            String endNum = start.toString();
            if (endNum.contains("666")) {
                count++;
            }
            if(count == N)
                break;
            start++;
        }

        System.out.println(start);
    }
}
