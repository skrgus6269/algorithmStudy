import java.util.*;
import java.io.*;

/**
 * 문제: 토마토
 * 메모레: 130260 kb
 * 시간: 672 ms
 * 풀이: 3차원 배열, bfs 활용
 */
public class B_7569 {
    static int[] dx = {0, 0, -1, 1, 0, 0};
    static int[] dy = {1, -1, 0, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static int M, N, H;
    static Queue<int[]> q;
    static int[][][] tomato;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        tomato = new int[N][M][H];

        q = new LinkedList<>();

        for(int k = 0; k < H; k++) {
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < M; j++) {
                    tomato[i][j][k] = Integer.parseInt(st.nextToken());
                    if(tomato[i][j][k] == 1) {
                        q.offer(new int[] {i, j, k, 0});
                    }
                }
            }
        }

        int result = bfs();

        for(int k = 0; k < H; k++) {
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(tomato[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        System.out.println(result);
    }

    static private int bfs() {
        int day = 0;

        while(!q.isEmpty()) {
            int[] current = q.poll();

            for(int i = 0; i < 6; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];
                int nz = current[2] + dz[i];

                if(nx < 0 || ny < 0 || nz < 0 || nx >= N || ny >= M || nz >= H || tomato[nx][ny][nz] == -1 || tomato[nx][ny][nz] == 1) continue;

                q.offer(new int[] {nx, ny, nz, current[3] + 1});

                tomato[nx][ny][nz] = 1;
                day = Math.max(day, current[3] + 1);
            }
        }
        return day;
    }
}
