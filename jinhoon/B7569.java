package sol.jinhoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/**
 * 문제: 토마토 (B7569)
 * 풀이: 3차원 BFS
 * 메모리: 97164kb
 * 시간: 612ms
 */
public class B7569 {

    int N, M, H;
    int[][][] map;
    int tomato;
    int time = 1;
    ArrayDeque<Point> q;

    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        q = new ArrayDeque<>();
        map = new int[H][N][M];

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    map[h][n][m] = Integer.parseInt(st.nextToken());

                    if (map[h][n][m] == 1) {
                        q.offer(new Point(m, n, h));
                    }
                    if (map[h][n][m] == 0) {
                        tomato++;
                    }
                }
            }
        }

        bfs();
        if (tomato != 0) {
            System.out.println(-1);
        } else {
            System.out.println(time - 1);
        }
    }

    int[] dx = {0, 0, 0, 0, 1, -1};
    int[] dy = {0, 0, 1, -1, 0, 0};
    int[] dz = {1, -1, 0, 0, 0, 0};

    private void bfs() {

        while (!q.isEmpty()) {
            Point cur = q.poll();
            for (int i = 0; i < 6; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                int nz = cur.z + dz[i];

                if (nx >= 0 && nx < M && ny >= 0 && ny < N && nz >= 0 && nz < H) {
                    if (map[nz][ny][nx] == 0) {
                        map[nz][ny][nx] = map[cur.z][cur.y][cur.x] + 1;
                        time = Math.max(map[nz][ny][nx], time);
                        q.offer(new Point(nx, ny, nz));
                        tomato--;
                    }
                }
            }
        }
    }

    static class Point {
        int x;
        int y;
        int z;

        public Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}

//public class Main {
//    public static void main(String[] args) throws IOException {
//        new B7569().solution();
//    }
//}
