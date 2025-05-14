import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(bufferedReader.readLine());

        Person[] people = new Person[count];
        for(int i = 0; i < count; ++i) {
            int[] input = Arrays.stream(bufferedReader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            people[i] = new Person(input[0], input[1]);
        }

        StringBuilder result = new StringBuilder();

        int[] rank = new int[count];
        for(int i = 0; i < count; ++i) {
            int index = 0;
            for(int j = 0; j < count; ++j) {
                if(i == j) {
                    continue;
                }
                if(people[j].weight > people[i].weight && people[j].tall > people[i].tall) {
                    index++;
                }
            }
            rank[i] = ++index;
        }
        for(int sequence : rank) {
            result.append(sequence).append(" ");
        }

        System.out.println(result);
    }

    private static class Person {
        int weight;
        int tall;

        public Person(int weight, int tall) {
            this.weight = weight;
            this.tall = tall;
        }
    }
}
