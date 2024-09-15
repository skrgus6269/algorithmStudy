package sol.jinhoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 문제: 이중 우선순위 큐 (B7662)
 * 풀이: 큐
 * 메모리: 464940kb
 * 시간: 3500ms
 */
public class B7662 {

    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int k = Integer.parseInt(br.readLine());

            Queue<Integer> minQ = new PriorityQueue<>();
            Queue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
            Map<Integer, Integer> map = new TreeMap<>();

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                String cmd = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if (cmd.equals("I")) {
                    map.put(num, map.getOrDefault(num, 0) + 1);

                    minQ.add(num);
                    maxQ.add(num);
                } else if (cmd.equals("D")) {
                    if (map.isEmpty()) {
                        continue;
                    }

                    if (num == 1) {
                        removeMap(maxQ, map);
                    } else if (num == -1) {
                        removeMap(minQ, map);
                    }
                }
            }

            if (map.isEmpty()) {
                result.append("EMPTY").append("\n");
            } else {
                int n = removeMap(maxQ, map);
                result.append(n).append(" ");
                if (map.isEmpty()) {
                    result.append(n).append("\n");
                } else {
                    result.append(removeMap(minQ, map)).append("\n");
                }
            }
        }

        System.out.println(result);
    }

    private int removeMap(Queue<Integer> minQ, Map<Integer, Integer> map) {
        int cur = 0;
        while (!minQ.isEmpty()) {
            cur = minQ.poll();
            int cnt = map.getOrDefault(cur, 0);

            if (cnt == 0) {
                continue;
            }

            if (cnt == 1) {
                map.remove(cur);
            } else {
                map.put(cur, cnt - 1);
            }

            break;
        }
        return cur;
    }
}

//public class Main {
//    public static void main(String[] args) throws IOException {
//        new B7662().solution();
//    }
//}
