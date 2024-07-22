package sol.jinhoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 문제: (B1202)
 * 풀이: 그리디 + 우선순위큐
 * 1. 용량이 작은 가방부터 채운다.
 * 2. 가방에 담을 수 있는 보석 중 가격이 가장 높은 것을 담는다.
 * 3. 보석의 가치를 기준으로 정렬하는 우선순위큐를 만들고, 가방이 허용하는 무게에 해당하는 모든 보석을 큐에 넣는다.
 * 4. 그럼 큐는 가방이 허용하는 무게의 최고가치의 보석을 제일 먼저 선출된다.
 * 5. 이를 반복한다.
 * 메모리: 115464kb
 * 시간: 1876ms
 */
public class B1202 {

    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Jewel[] jewels = new Jewel[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            jewels[i] = new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        PriorityQueue<Jewel> pq = new PriorityQueue<>((o1, o2) -> o2.V - o1.V);

        Arrays.sort(bags);
        Arrays.sort(jewels, Comparator.comparingInt(o -> o.M));

        long result = 0;
        int jstart = 0;
        for (int i = 0; i < K; i++) {
            int now = bags[i];

            for (; jstart < N; jstart++) {
                // 현재 가방 무게 이하인 보석은 우선순위큐에 다 넣는다.
                if (jewels[jstart].M <= now) {
                    pq.offer(jewels[jstart]);
                } else {
                    break;
                }
            }
            // 가방에 넣을 수 있는 보석중 최고 가치 보석을 가방에 넣는다.
            if (!pq.isEmpty()) {
                result += pq.poll().V;
            }
        }


        System.out.println(result);
    }

    static class Jewel {
        int M;
        int V;

        Jewel(int a, int b) {
            M = a;
            V = b;
        }
    }
}

//public class Main {
//    public static void main(String[] args) throws IOException {
//        new B1202().solution();
//    }
//}
