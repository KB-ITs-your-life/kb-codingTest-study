package week08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class BOJ_1991 {
    static HashMap<String, TreeNode> map;
    static String result = "";

    static void dfs1(String root) {
        TreeNode node = map.get(root);
        if (node == null) {return;}

        String left = map.get(root).left;
        String right = map.get(root).right;

        result += root;
        dfs1(left);
        dfs1(right);

    }
    static void dfs2(String root) {
        TreeNode node = map.get(root);
        if (node == null) {return;}

        String left = map.get(root).left;
        String right = map.get(root).right;

        dfs2(left);
        result += root;
        dfs2(right);
    }
    static void dfs3(String root) {
        TreeNode node = map.get(root);
        if (node == null) {return;}

        String left = map.get(root).left;
        String right = map.get(root).right;

        dfs3(left);
        dfs3(right);
        result += root;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");

            map.put(input[0], new TreeNode(input[1], input[2]));
        }

        dfs1("A");
        System.out.println(result);
        result = "";
        dfs2("A");
        System.out.println(result);
        result = "";
        dfs3("A");
        System.out.println(result);

    }
}

class TreeNode {
    String left;
    String right;

    TreeNode (String left, String right) {
        this.left = left;
        this.right = right;
    }
}
