package week08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ1991 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 노드의 이름은 A부터 차례대로 알파벳 대문자로 매겨진다.
        // Tree 생성
        Map<Character, TreeNode> nodeMap = new HashMap<>();
        TreeNode root = null;

        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            Character parent = st.nextToken().charAt(0);
            Character left = st.nextToken().charAt(0);
            Character right = st.nextToken().charAt(0);

            nodeMap.putIfAbsent(parent, new TreeNode(parent));
            TreeNode parentNode = nodeMap.get(parent);

            if(i == 0) root = parentNode; // 루트 노드

            if(left != '.'){
                nodeMap.putIfAbsent(left, new TreeNode(left));
                parentNode.left = nodeMap.get(left);
            }
            if(right != '.'){
                nodeMap.putIfAbsent(right, new TreeNode(right));
                parentNode.right = nodeMap.get(right);
            }
        }

        // 트리 순회
        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
    }
    private static void preOrder(TreeNode node) {
        if(node == null) return;

        System.out.print(node.val);
        preOrder(node.left);
        preOrder(node.right);
    }
    private static void inOrder(TreeNode node) {
        if(node == null) return;

        inOrder(node.left);
        System.out.print(node.val);
        inOrder(node.right);
    }
    private static void postOrder(TreeNode node) {
        if(node == null) return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.val);
    }

    static class TreeNode{
        Character val;
        TreeNode left, right;
        public TreeNode(Character val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
}
