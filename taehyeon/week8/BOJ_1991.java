package week8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1991 {
    static class Node {
        char val;
        Node left;
        Node right;
        Node(char val){
            this.val = val;
            this.left = left;
            this.right = right;
        }

    }
    static Node[] tree;

    static void preOrder(Node root){
        if (root == null) return;
        System.out.print(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }
    static void inOrder(Node root){
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.val);
        inOrder(root.right);
    }
    static void postOrder(Node root){
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val);

    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        tree = new Node[n+1];

        for(int i = 1; i <= n; i++){
            st=new StringTokenizer(br.readLine());
            char parentVal=st.nextToken().charAt(0);
            char leftVal=st.nextToken().charAt(0);
            char rightVal=st.nextToken().charAt(0);
            if (tree[parentVal - 'A'] == null) { // 부모 노드가 아직 생성되지 않은 경우. 'A'는 문자 'A'의 ASCII 값
                tree[parentVal - 'A'] = new Node(parentVal); // 부모 노드를 생성
            }
            if(leftVal != '.') {
                tree[leftVal - 'A'] = new Node(leftVal);
                tree[parentVal - 'A'].left = tree[leftVal - 'A'];
            }
            if(rightVal != '.') {
                tree[rightVal - 'A'] = new Node(rightVal);
                tree[parentVal - 'A'].right = tree[rightVal - 'A'];

            }

        }
        preOrder(tree[0]);
        System.out.println();
        inOrder(tree[0]);
        System.out.println();
        postOrder(tree[0]);



    }
}