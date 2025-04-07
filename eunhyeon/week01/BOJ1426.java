package week01;

import java.util.Scanner;

public class BOJ1426 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0; // 종말의 수 개수를 세는 변수
        int num = 666; // 첫 번째 종말의 수

        while (true) {
            if (String.valueOf(num).contains("666")) {
                count++; // 종말의 수를 찾을 때마다 증가
            }
            if (count == N) {
                System.out.println(num);
                break;
            }
            num++; // 다음 숫자로 이동
        }
    }

}
