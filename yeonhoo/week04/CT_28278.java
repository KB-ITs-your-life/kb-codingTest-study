package yeonhoo.week04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class CT_28278 {
    // 정수 명령어들을 입력받아, 스택을 구현하는 문제
    // 스택은 FILO (First In, Last Out)
    public static void main(String[] args) throws IOException {
        //정수 명령어를 입력받기 위해서는 BufferReader, Scanner 사용
        //장점 - Scanner 보다 빠른 처리속도 (그럼 Scanner는 왜 써? - 차이점 공부해보기)
        //throws를 쓴다는 것은, 해당 메소드 안에서 try/catch를 사용하지 않는다는 것 (원리 공부해보기)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String str = br.readLine();

//        System.out.println(str);
        //BufferReader의 readLine() 메소드를 이용하여 사용자 입력 한 줄을 받는다.
        //근데 입력받을 때 명령어가 숫자이기에 String -> Integer 변환이 필요하다.
        //그렇게 찾은 방법이 Integer.parseInt()
        int number = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        // 제네릭으로 stack이라는 이름의 스택 선언
        StringBuilder sb = new StringBuilder();
        //String은 불변의 객체라고 함. 한 번 생성되면 변경할 수 없다.
        //append를 쓰기 위해
        //sout보다 연산 수를 줄여줄 수 있다고 함

        for (int i = 0;  i < number ; i++) {
            //5를 입력하면 5개의 명령어 이므로 0<5, 0,1,2,3,4 이런식으로 5개의 명령어를 입력받을 수 있음
            StringTokenizer st = new StringTokenizer(br.readLine());
            //String을 token단위로 끊어주는 StringTokenizer 클래스
            //BufferReadr로 라인을 읽고 그 라인에서 특정 문자열로 읽어드리기 위해서 필요
             int command = Integer.parseInt(st.nextToken());
             // 사용자가 입력한 1~5명령어인 command 선언

            if (command == 1) {
                int x = Integer.parseInt(st.nextToken());
                stack.push(x);
                // 1 X: 정수 X를 스택에 넣는다. (1 ≤ X ≤ 100,000)
                // 1번 명령어 입력후 사용자가 입력한 숫자 x를 스택에 푸시한다.
            }

            if (command == 2) {
                if (stack.isEmpty()) {
                    sb.append("-1 \n");
                    }else{
                    sb.append(stack.pop() + "\n");
                    // 2: 스택에 정수가 있다면 맨 위의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
                    // isEmpty():비어있는지 확인, 비어있다면 -1을 출력하고 개행
                    // 비어있는게 아니라면, pop():맨 위의 정수를 "빼고" 출력
                }
            }

            if (command == 3) {
                sb.append(stack.size() + "\n");
                // 3: 스택에 들어있는 정수의 개수를 출력한다.
                // size(): 스택에 들어있는 개수를 출력하고 개행
            }

            if (command == 4) {
                if (stack.isEmpty()){
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                 // 4: 스택이 비어있으면 1, 아니면 0을 출력한다.
                 // 비어있으면 1을 출력, 그게 아니라면 0을 출력하고 개행   
                }
            }

            if (command == 5) {
                if (stack.isEmpty()) {
                    sb.append("-1\n");
                }else{
                    sb.append(stack.peek() + "\n");
                    // 5: 스택에 정수가 있다면 맨 위의 정수를 출력한다. 없다면 -1을 대신 출력한다.
                    // 비어있으면 -1을 출력하고 개행, 그게 아니라면 맨 위의 값을 출력하고 개행
                    // pop : 데이터를 stack에서 꺼내서 읽기
                    // peek : 데이터를 stack에서 꺼내지 않고 값만 읽기
                }
            }
        }
        System.out.println(sb);
        // 지금까지 StringBuilder에 누적해온 모든 결과를 출력
    }
}
