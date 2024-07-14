import java.io.*;
import java.util.*;

/**
 * 문제: 미로탐색
 * 메모리: 12360 kb
 * 시간: 92 ms
 * 풀이: bfs 사용, depth 1씩 늘려서 큐에 배열로 저장
 */
public class B_2178 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int N, M;
    static char[][] graph;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new char[N][M];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                graph[i][j] = str.charAt(j);
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0, 0});

        int[] current = new int[3];
        while(!q.isEmpty()) {
            current = q.poll();

            if(current[0] == N-1 && current[1] == M-1) break;

            for(int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                if(graph[nx][ny] == '1') {
                    graph[nx][ny] = '0';
                    q.offer(new int[] {nx, ny, current[2]+1});
                }
            }
        }

        System.out.println(current[2]+1);
    }
}
