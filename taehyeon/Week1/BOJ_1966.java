package Week1;

import java.io.*;
import java.util.*;

public class BOJ_1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        StringBuilder sb=new StringBuilder();

        int n=Integer.parseInt(st.nextToken());
        LinkedList<int[]> q = new LinkedList<>(); // 중요도와 인덱스를 담은 배열있는 큐 생성.

        for(int i=1;i<=n;i++){  //테스트 케이스 반복
            q.clear();          // have to clear Queue for each case

            st=new StringTokenizer(br.readLine()," ");
            int size=Integer.parseInt(st.nextToken());
            int idx=Integer.parseInt(st.nextToken());  // idx번째의 문서가 몇번째에 인쇄되느냐



            st=new StringTokenizer(br.readLine()," ");

            for(int j=0;j<size;j++){
                q.add(new int[]{j, Integer.parseInt(st.nextToken())});   //{ 초기 인덱스, 중요도 }
            }

            int count=0;  //정답 카운트

            while(!q.isEmpty()){
                //Que의 가장 앞에 있는 요소를 꺼냄
                int[] head=q.poll();
                boolean maxNum=true;

                for(int j=0;j<q.size();j++){
                    if(head[1]<q.get(j)[1]){ // 제일 앞의 요소와 나머지 요소의 중요도 비교
                        q.offer(head);  //head가 j번째 원소보다 중요도가 작으면 맨뒤로 보낸다.
                        for(int k=0;k<j;k++){   //  head 제외 j이전 원소도 뒤로 보낸다.
                            q.offer(q.poll());
                        }
                        maxNum=false;  // head가 가장 큰 원소가 아니였으므로 false를 하고 탐색을 마침
                        break;
                    }

                }
                //만약 꺼냈던 head가 가장 큰 요소면 poll되었으므로 que에서 빠져나갔다.
                // head 원소가 가장 큰 원소가 아니였으므로 다음 반복문으로 넘어감
                if(!maxNum) {
                    continue;
                }

                //head원소가 가장큰 수이므로 count를 증가시킴.
                count++;
                if(head[0] == idx) {	// 찾고자 하는 문서라면 해당 테스트케이스 종료
                    break;
                }

            }
            sb.append(count).append("\n");

        }
        System.out.println(sb);

    }
}