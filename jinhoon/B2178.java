package sol.jinhoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 문제: 미로탐색 (B2178)
 * 풀이: BFS
 * 메모리: 14752kb
 * 시간: 144ms
 */
public class B2178 {


    int N;
    int M;
    int[][] arr;
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int[][] visited;

    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new int[N][M];
        for (int i = 0; i < N; i++) {
            char[] temp = (br.readLine()).toCharArray();
            for (int j = 0; j < M; j++) {
                arr[i][j] = temp[j] - '0';
            }
        }

        bfs(new Point(0, 0));

        System.out.println(visited[N - 1][M - 1]);
    }

    private void bfs(Point start) {

        Queue<Point> q = new LinkedList<>();
        visited[start.y][start.x] = 1;
        q.offer(start);

        while (!q.isEmpty()) {
            Point current = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];

                if (nextX >= 0 && nextX < M && nextY >= 0 && nextY < N && arr[nextY][nextX] == 1) {
                    if (visited[nextY][nextX] == 0) {
                        visited[nextY][nextX] = visited[current.y][current.x] + 1;
                        q.offer(new Point(nextX, nextY));
                    }

                }
            }
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
//        new B2178().solution();
//    }
//}
