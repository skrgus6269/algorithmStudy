package sol.jinhoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 문제: 연구소 (B14502)
 * 풀이: dfs + bfs
 * 메모리: 303212kb
 * 시간: 852ms
 */
public class B14502 {

    int N, M;
    int[][] map;
    int[][] originMap;
    Queue<Point> q;
    List<Point> virus;
    int result;

    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        virus = new ArrayList<>();
        map = new int[N][M];
        originMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                originMap[i][j] = num;
                if (num == 2) {
                    virus.add(new Point(j, i));
                }
            }
        }

        setWall(0);

        System.out.println(result);
    }

    private void setWall(int count) {
        if (count == 3) {
            checkVirus();
            countSafeZone();
            copyArr();
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                if (originMap[i][j] == 0) {
                    originMap[i][j] = 1;
                    setWall(count + 1);
                    originMap[i][j] = 0;
                }

            }
        }
    }

    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    private void checkVirus() {
        q = new LinkedList<>();
        q.addAll(virus);


        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx >= 0 && nx < M && ny >= 0 && ny < N && map[ny][nx] == 0) {
                    map[ny][nx] = 2;
                    q.offer(new Point(nx, ny));
                }
            }
        }
    }

    private void countSafeZone() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    count++;
                }
            }
        }
        result = Math.max(count, result);
    }

    private void copyArr() {
        for (int i = 0; i < N; i++) {
            System.arraycopy(originMap[i], 0, map[i], 0, M);
        }
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

//public class Main {
//    public static void main(String[] args) throws IOException {
//        new B14502().solution();
//    }
//}
