import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 문제: 보석 도둑
 * 메모리: 142016 kb
 * 시간: 1600 ms
 * 풀이: 람다식을 이용한 정렬, 보석 정보 클래스 사용
 *      이중 for문 시간초과 -> 우선순위 큐 사용
 */
class Jewel {
    int m, v;

    public Jewel(int m, int v) {
        this.m = m;
        this.v = v;
    }
}

public class B_1202 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 보석 개수
        int K = Integer.parseInt(st.nextToken());   // 가방 개수

        List<Jewel> jewels = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());   // 무게
            int v = Integer.parseInt(st.nextToken());   // 가격

            jewels.add(new Jewel(m, v));
        }

        List<Integer> bags = new ArrayList<>();
        for(int i = 0; i < K; i++) {
            bags.add(Integer.parseInt(br.readLine()));
        }

        // 람다식을 이용한 보석들 정렬 (무게로 오름 차순, 무게 같으면 가격으로 오름차순은 굳이 안해도 될듯)
        jewels.sort(
                (o1, o2) -> {
                    return o1.m - o2.m;
                }
        );

        // 가방 무게순으로 오름차순 정렬
        Collections.sort(bags);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());    // 우선순위 큐 내림차순으로 사용

        int startIdx = 0;
        long result = 0;
        for(int bagM : bags) {
            for(int i = startIdx; i < N; i++) {
                if(jewels.get(i).m > bagM) break;

                pq.offer(jewels.get(i).v);
                startIdx = i+1;
            }

            if(!pq.isEmpty()) {
                result += pq.poll();
            }
        }

        System.out.println(result);

    }
}
