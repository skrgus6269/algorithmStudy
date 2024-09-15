import java.io.*;
import java.util.*;

/**
 * 문제: 이중 우선순위 큐
 * 메모리: 445584 kb
 * 시간: 2724 ms
 * 풀이: 우선순위 큐, map 사용
 */
public class B_7662 {
    static Map<Integer, Integer> map;   // 실제 큐에 있는 숫자들
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> pqMin = new PriorityQueue<>();
            PriorityQueue<Integer> pqMax = new PriorityQueue<>(Comparator.reverseOrder());
            map = new HashMap<>();

            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                String str = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if(str.equals("I")) {
                    pqMin.offer(num);
                    pqMax.offer(num);
                    map.put(num, map.getOrDefault(num, 0)+1);
                    continue;
                }

                if(map.size() == 0) continue;   // 큐가 비어있어도 진행

                if(num == -1) {
                    delete(pqMin);
                } else {
                    delete(pqMax);
                }
            }

            if(map.size() == 0) {
                System.out.println("EMPTY");
                continue;
            }

            int result = delete(pqMax);
            System.out.print(result + " ");

            // 최대값이랑 최소값이랑 겹치는 경우
           if(map.size() == 0) {
                System.out.println(result);
                continue;
            }

            System.out.println(delete(pqMin));
        }
    }

    static private int delete(PriorityQueue<Integer> queue) {
        int current = 0;
        while(true) {
            current = queue.poll();

            int count = map.getOrDefault(current, 0);
            if(count == 1) {
                map.remove(current);
                break;
            }

            if(count != 0) {
                map.put(current, count-1);
                break;
            }
        }

        return current;
    }
}
