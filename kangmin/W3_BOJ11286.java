import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
    java 11 / 26100KB / 332ms
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int absO1 = Math.abs(o1);
                int absO2 = Math.abs(o2);

                if (absO1 == absO2) {
                    return o1 - o2;
                }

                return absO1 - absO2;
            }
        });

        for (int i = 0; i < T; i++) {
            int input = Integer.parseInt(br.readLine());

            if (input == 0) {
                if (pq.isEmpty()) {
                    sb.append("0").append("\n");
                    continue;
                }
                sb.append(pq.poll()).append("\n");
                continue;
            }

            pq.offer(input);
        }

        System.out.print(sb);

    }

}
