package week01;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ7568 {

    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 사람 수

        Person[] list = new Person[N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); // 몸무게
            int y = Integer.parseInt(st.nextToken()); // 키
            Person person = new Person(x, y);
            list[i] = person;
        }

        // 순위 정하기
        int count = 1;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(list[i].height < list[j].height
                        && list[i].weight < list[j].weight) {
                    count++;
                }
            }
            list[i].rank = count;
            count = 1;
        }

        // 정답 출력
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < N; i++){
            answer.append(list[i].rank).append(' ');
        }

        System.out.println(answer);
    }

    static class Person{
        int weight;
        int height;
        int rank;

        public Person(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }
    }
}