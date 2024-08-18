import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

/*
    BOJ 11279
    java 11 / 32272 KB / 800 ms
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());

            if (0 < input) {
                pq.add(input);
                continue;
            }

            if (pq.isEmpty()) {
                System.out.println(0);
                continue;
            }

            System.out.println(pq.poll());
        }
    }
}
