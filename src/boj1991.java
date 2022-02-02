import java.util.*;
import java.io.*;

public class boj1991 {
    static BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String args[]) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(bfr.readLine());
        Tree tree = new Tree();

        int n = Integer.parseInt(stk.nextToken());
        for (int i = 0; i < n; i++) {
            stk = new StringTokenizer(bfr.readLine());
            tree.add(stk.nextToken().charAt(0), stk.nextToken().charAt(0), stk.nextToken().charAt(0));
        }
        tree.preorder(tree.root);   bfw.newLine();
        tree.inorder(tree.root);    bfw.newLine();
        tree.postorder(tree.root);
        bfw.close();
    }

    static class Node {
        char data;
        Node left;
        Node right;

        Node(char data) {
            this.data = data;
        }
    }

    static class Tree {
        Node root;

        void add(char data, char leftData, char rightData) {
            if (root == null) { // 루트가 아직 비어있으면
                root = new Node(data);
                if (leftData != '.') root.left = new Node(leftData);
                if (rightData != '.') root.right = new Node(rightData);
            } else search(root, data, leftData, rightData);
        }

        void search(Node curNode, char data, char leftData, char rightData) {
            if (curNode == null) return; // 끝까지 왔는데 자리 없으면 종료
            else if(curNode.data == data){
                if (leftData != '.') curNode.left = new Node(leftData);
                if (rightData != '.') curNode.right = new Node(rightData);
            }
            else{
                search(curNode.left, data, leftData, rightData);
                search(curNode.right, data, leftData, rightData);
            }
        }

        void preorder(Node curNode) throws IOException {
            bfw.write(curNode.data+"");
            if(curNode.left!=null)  preorder(curNode.left);
            if(curNode.right!=null) preorder(curNode.right);
        }

        void inorder(Node curNode) throws IOException {
            if(curNode.left!=null)  inorder(curNode.left);
            bfw.write(curNode.data+"");
            if(curNode.right!=null) inorder(curNode.right);
        }

        void postorder(Node curNode) throws IOException {
            if(curNode.left!=null)  postorder(curNode.left);
            if(curNode.right!=null) postorder(curNode.right);
            bfw.write(curNode.data+"");
        }
    }
}