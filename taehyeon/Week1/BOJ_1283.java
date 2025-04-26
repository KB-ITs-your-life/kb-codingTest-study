package Week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


/*
* 풀이 방식
* 0. func에 기능 저장.
* 1. 인덱스가 저장되는 loc와 값이 있는 hotKey 생성
* 2. 기능 String을 순회하며 hotKey에 있는지 확인 후 만약 없다면
* 2-1. 첫번째 요소거나 공백을 만나면 frontVaild을 true로 바꿈
* 2-2. 만약 frontVaild가 참이면 frontCharacter에 현재 요소 할당 후 frontValid 거짓으로 변환
* 2-3. 만약 frontCharacter에 요소가 할당된다면 hotKey에 추가하고 순회문 종료
* 2-4. ohterCharacter가 할당된다면 otherValid를 참으로 만든다.
* 2-5. otherValid가 참이고 frontCharacter에 요소가 없다면 otherCharacter hotKey에 추가.
* 3. 모든 조건에 만족하지 않는다면 단축키 안만드므로 loc과 hotKey에 -1과 '0' 각각 추가.
* 4. func 순회하며 출력하는데 loc[i]가 -1이라면 sb에 func 그대로 추가.
* 4-1. -1이 아니면 func 요소에 loc[i] 앞뒤로 [,] 추가해 출력.
*
* */

public class BOJ_1283 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());

        List<Integer> loc = new ArrayList<>();
        List<Character> hotKey=new ArrayList<>();


        char frontCharacter = 'a';
        char otherCharacter= 'a';
        char tempCharacter;
        int[] index=new int[2];

        int len;

        String[] func=new String[N];
        for(int i=0;i<N;i++){
            func[i]=br.readLine();
        }
        for(int i=0;i<N;i++){
            boolean frontVaild=true;
            boolean otherVaild=false;
            boolean frontIn=false;


            len=func[i].length();
            for(int j=0;j<len;j++){
                /* 공백을 만난다면 frontValid를 참으로 바꾸고 넘기기. */
                if (func[i].charAt(j)==' '){
//                    System.out.println("출력한번 or not");
                    frontVaild=true;
                    continue;
                }

                /* 비교하려는 문자는 소문자로 비교 */
                tempCharacter=Character.toLowerCase(func[i].charAt(j));

                if(hotKey.contains(tempCharacter)){ //hotKey한테 현재 단어가 있는지
                    if(frontVaild){ //만약 단어의 앞이었으면 다시 바꿔줌
                        frontVaild=false;
                    }
                    continue;
                } else { /* hotKey에 tempCharacter가 없다면 */
                    /* 맨 앞의 문자인지 확인 필요 */
                    if (frontVaild && frontIn==false){
//                        System.out.printf("%c 지금 나오는 것",tempCharacter);
//                        System.out.println();
                        frontCharacter=tempCharacter;
                        frontIn=true;
                        index[0]=j;
                        frontVaild=false;
                    } else if(!otherVaild){
                        /* otherValid가 거짓일때만 할당 */
//                        System.out.println("출력한번만 되어야함");
                        otherCharacter=tempCharacter;
                        otherVaild=true;
                        index[1]=j;
                    }

                }



            }
            if (frontIn){  /* 단어의 앞 문자가 쓰였을 때 */
//                System.out.println("앞에서 들어감");
                hotKey.add(frontCharacter);
                loc.add(index[0]);
            } else if (otherVaild) { /* 그 외의 단어가 쓰였으며 추가할 수 있을 때 */
//                System.out.println("뒤에서 들어감");
                hotKey.add(otherCharacter);
                loc.add(index[1]);
            } else {
                hotKey.add('0');
                loc.add(-1);
            }

        }

        for(int i=0;i<N;i++){
//            System.out.println(func[i]);
//            System.out.println(loc.get(i));
            if (loc.get(i)==-1){
                sb.append(func[i]).append("\n");
                continue;
            } else if (loc.get(i)==0) {
                String sum="["+func[i].charAt(0)+"]"+func[i].substring(1);
                sb.append(sum).append("\n");
                continue;
            } else {
                String front=func[i].substring(0,loc.get(i));
                String mid=func[i].substring(loc.get(i),loc.get(i)+1);
                String rear=func[i].substring(loc.get(i)+1);
                String sum=front+"["+mid+"]"+rear;
                sb.append(sum).append("\n");
            }
        }
        System.out.println(sb);


    }
}



























