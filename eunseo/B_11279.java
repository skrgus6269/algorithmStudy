import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 문제: 최대 힙
 * 메모리: 35116 kb
 * 시간: 1072 ms
 * 풀이: PriorityQueue 사용
 */
public class B_11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

//        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < N; i++) {
            int check = Integer.parseInt(br.readLine());

            if(check != 0) {
                queue.offer(check);
                continue;
            }

            if(queue.isEmpty()) {
                System.out.println(0);
                continue;
            }

            System.out.println(queue.poll());
        }
    }
}
