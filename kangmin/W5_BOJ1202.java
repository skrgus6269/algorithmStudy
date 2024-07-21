import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    BOJ 1202 보석 도둑
    java 11 / 119068 KB / 1996 ms
 */
public class Main {

    static class Jewelry {
        int value;
        int weight;

        public Jewelry(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N, K;
        long result = 0;
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        Jewelry[] jewelries = new Jewelry[N];
        int[] bags = new int[K];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            jewelries[i] = new Jewelry(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        /*
            무게 기준으로 오름차순으로 정렬
            무게가 같을 경우 가치 기준 내림차순 정렬
         */
        Arrays.sort(jewelries, new Comparator<Jewelry>() {
            @Override
            public int compare(Jewelry o1, Jewelry o2) {
                if (o1.weight == o2.weight) {
                    return o2.value - o1.value;
                }

                return o1.weight - o2.weight;
            }
        });

        for (int i = 0; i < K; i++) {
            bags[i] = (Integer.parseInt(br.readLine()));
        }
        /*
            가방이 담을 수 있는 무게 오름차순으로 정렬
         */
        Arrays.sort(bags);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0, j = 0; i < K; i++) {
            /*
                가방이 담을 수 있는 보석 pq에 넣음
             */
            while (j < N && jewelries[j].weight <= bags[i]) {
                pq.offer(jewelries[j++].value);
            }

            /*
                pq에 있는 보석은 모두 가방에 담을 수 있음
                그 중 가장 가치가 높은 보석 담기
             */
            if (!pq.isEmpty()) {
                result += pq.poll();
            }
        }

        System.out.print(result);
    }

}

