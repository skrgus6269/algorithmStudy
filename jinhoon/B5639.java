package sol.jinhoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문제: 이진 검색 트리 (B5639)
 * 풀이: 트리
 * 메모리: 17932kb
 * 시간: 628ms
 */
public class B5639 {

    StringBuilder result = new StringBuilder();

    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node root = new Node(Integer.parseInt(br.readLine()));
        while (true) {
            String num = br.readLine();
            if (num == null || num.equals("")) {
                break;
            }
            root.insert(Integer.parseInt(num));
        }
        postOrder(root);

        System.out.println(result);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }

        postOrder(node.left);
        postOrder(node.right);
        result.append(node.value).append("\n");
    }

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        void insert(int n) {
            if (n < this.value) {
                if (this.left == null) {
                    this.left = new Node(n);
                } else {
                    this.left.insert(n);
                }
            }

            if (n > this.value) {
                if (this.right == null) {
                    this.right = new Node(n);
                } else {
                    this.right.insert(n);
                }
            }
        }
    }
}

//public class Main {
//    public static void main(String[] args) throws IOException {
//        new B5639().solution();
//    }
//}
