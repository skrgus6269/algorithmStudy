import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 문제: A → B
 * 메모리: 15284 kb
 * 시간: 92 ms
 * 풀이: bfs 사용
 */
public class B_16953 {
    static class Node {
        long num;   // 범위 초과 고려하여 long 타입
        int count;

        Node(long num, int count) {
            this.num = num;
            this.count = count;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Queue<Node> queue = new LinkedList<>();

        queue.offer(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.num == end) {
                System.out.println(current.count + 1);
                return;
            }

            long A = current.num * 2;
            long B = current.num * 10 + 1;

            if (A <= end) {
                queue.offer(new Node(A, current.count + 1));
            }

            if (B <= end) {
                queue.offer(new Node(B, current.count + 1));
            }
        }

        System.out.println(-1);
    }
}
