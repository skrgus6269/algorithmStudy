package sol.jinhoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 문제: 최소비용 구하기 (B1916)
 * 풀이: 다익스트라
 * 메모리: 51532kb
 * 시간: 480ms
 */
public class B1916 {

    int N, M;
    List<List<Bus>> graph;
    int[] dist;
    boolean[] visit;
    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        dist = new int[N + 1];
        visit = new boolean[N + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Bus(end, weight));
        }

        st = new StringTokenizer(br.readLine());
        int sCity = Integer.parseInt(st.nextToken());
        int eCity = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra(sCity, eCity));
    }

    public int dijkstra(int start, int end) {
        PriorityQueue<Bus> pq = new PriorityQueue<>();
        pq.offer(new Bus(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Bus curBus = pq.poll();
            int cur = curBus.end;

            if (!visit[cur]) {
                visit[cur] = true;

                for (Bus bus : graph.get(cur)) {
                    if (!visit[bus.end] && dist[bus.end] > dist[cur] + bus.weight) {
                        dist[bus.end] = dist[cur] + bus.weight;
                        pq.add(new Bus(bus.end, dist[bus.end]));
                    }
                }
            }
        }
        return dist[end];
    }

    static class Bus implements Comparable<Bus> {
        int end;
        int weight;

        public Bus(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Bus o) {
            return this.weight - o.weight;
        }
    }
}

//public class Main {
//    public static void main(String[] args) throws IOException {
//        new B1916().solution();
//    }
//}
