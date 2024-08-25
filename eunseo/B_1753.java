import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 문제: 최단경로
 * 메모리: 114480 kb
 * 시간: 2280 ms
 * 풀이: 다익스트라 알고리즘 사용
 */
public class B_1753 {
    static class Vertex {
        int v;
        int w;  // 가중치

        Vertex(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());   // 정점의 개수
        int E = Integer.parseInt(st.nextToken());   // 간선의 개수
        int start = Integer.parseInt(br.readLine());    // 시작 정점
        List[] adjList = new ArrayList[V+1];    // 인접 리스트

        for(int i = 0; i <= V; i++) {
            adjList[i] = new ArrayList<>();
        }

        for(int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adjList[u].add(new Vertex(v, w));
        }

        int[] distance = new int[V+1];
        boolean[] visited = new boolean[V+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        for(int c = 0; c < V; c++) {
            int min = Integer.MAX_VALUE;
            int current = -1;

            for(int i = 1; i <= V; i++) {
                if(!visited[i] && min > distance[i]) {
                    current = i;
                    min = distance[i];
                }
            }

            if(current == -1) break;

            visited[current] = true;
            for(int i = 0; i < adjList[current].size(); i++) {
                Vertex v = (Vertex) adjList[current].get(i);
                if(!visited[v.v] && distance[v.v] > min + v.w) {
                    distance[v.v] = min + v.w;
                }
            }
        }

        for(int i = 1; i <= V; i++) {
            if(distance[i] != Integer.MAX_VALUE) {
                sb.append(distance[i]).append("\n");
            } else {
                sb.append("INF\n");
            }
        }

        System.out.println(sb);
    }
}
