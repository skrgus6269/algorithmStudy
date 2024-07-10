package sol.jinhoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * 문제: 절댓값 힙(B11286)
 * 풀이: 우선순위 큐
 * 메모리: 25732kb
 * 시간: 288ms
 */
public class B11286 {

    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int a1 = Math.abs(o1);
            int a2 = Math.abs(o2);
            if (a1 == a2) {
                return o1 - o2;
            }
            return a1 - a2;
        });

        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(br.readLine());
            if (cur == 0) {
                if (pq.isEmpty()) {
                    result.append(0).append("\n");
                } else {
                    result.append(pq.poll()).append("\n");
                }
            } else {
                pq.offer(cur);
            }
        }

        System.out.println(result);
    }
}

//public class Main {
//    public static void main(String[] args) throws IOException {
//        new B11286().solution();
//    }
//}
