package sol.jinhoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 문제: 적록색약 (B10026)
 * 풀이: BFS
 * 메모리: 18928kb
 * 시간: 176ms
 */
public class B10026 {

    int N;
    char[][] map1;
    char[][] map2;
    boolean[][] isVisited;

    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map1 = new char[N][N];
        map2 = new char[N][N]; // 적록색맹 맵
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < N; j++) {
                char c = temp.charAt(j);
                map1[i][j] = c;
                map2[i][j] = c;
                if (c == 'G') {
                    map2[i][j] = 'R';
                }
            }
        }

        int sum1 = 0;
        int sum2 = 0;
        isVisited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum1 += bfs(map1, new int[]{i, j});
            }
        }

        isVisited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum2 += bfs(map2, new int[]{i, j});
            }
        }

        System.out.println(sum1 + " " + sum2);
    }

    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    private int bfs(char[][] map, int[] start) {
        Queue<int[]> q = new LinkedList<>();
        if (isVisited[start[0]][start[1]]) {
            return 0;
        } else {
            isVisited[start[0]][start[1]] = true;
        }
        q.offer(start);


        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[ny][nx] == map[start[0]][start[1]]) {
                    if (!isVisited[ny][nx]) {
                        q.offer(new int[]{ny, nx});
                        isVisited[ny][nx] = true;
                    }
                }
            }
        }

        return 1;
    }
}

//public class Main {
//    public static void main(String[] args) throws IOException {
//        new B10026().solution();
//    }
//}
