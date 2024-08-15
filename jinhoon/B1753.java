package sol.jinhoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 문제: 최단 경로 (B1753)
 * 풀이: 다익스트라
 * 메모리: 108472kb
 * 시간: 644ms
 */
public class B1753 {

    int V, E, S;
    List<Node>[] list;
    int[] dist;
    static final int INF = 100_000_000;
    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(br.readLine());
        list = new ArrayList[V + 1];
        dist = new int[V + 1];
        Arrays.fill(dist, INF);

        for (int i = 0; i <= V; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[start].add(new Node(end, weight));
        }

        dijkstra(S);

        for (int i = 1; i <= V; i++) {
            if (dist[i] == INF) {
                result.append("INF\n");
            } else {
                result.append(dist[i]).append("\n");
            }
        }

        System.out.println(result);
    }

    private void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] check = new boolean[V + 1];
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int next = cur.end;

            if (!check[next]) {
                check[next] = true;

                for (Node node : list[next]) {
                    if (dist[node.end] > dist[next] + node.weight) {
                        dist[node.end] = dist[next] + node.weight;
                        pq.add(new Node(node.end, dist[node.end]));
                    }
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int end, weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }


        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}

//public class Main {
//    public static void main(String[] args) throws IOException {
//        new B1753().solution();
//    }
//}
