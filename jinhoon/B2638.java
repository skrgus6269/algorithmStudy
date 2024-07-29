package sol.jinhoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 문제: 치즈(B2638)
 * 풀이: 구현 + BFS
 * 1. 외부공기와 내부공기를 구별한다.
 * 2. 외부공기 2회 이상 닿은 치즈를 삭제한다.
 * 3. 치즈가 다 삭제될때까지 1,2 를 반복한다.
 * 메모리: 41156kb
 * 시간: 284ms
 */
public class B2638 {

    int[][] map;
    boolean[][] visited;
    int time, N, M;
    int cheese;

    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    cheese++;
                }
            }
        }

        while (cheese != 0) {
            visited = new boolean[N][M];
            checkOutsideAir();
            deleteCheese();
            time++;
        }

        System.out.println(time);
    }

    // 외부공기는 2로 변경
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    private void checkOutsideAir() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        visited[0][0] = true;
        map[0][0] = 2;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = cur[0] + dy[i];
                int nx = cur[1] + dx[i];

                if (nx < M && nx >= 0 && ny < N && ny >= 0 && !visited[ny][nx] && map[ny][nx] != 1) {
                    map[ny][nx] = 2;
                    q.offer(new int[]{ny, nx});
                    visited[ny][nx] = true;
                }

            }
        }
    }

    // 치즈 녹음
    private void deleteCheese() {

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                if (map[i][j] == 1) {

                    int cnt = 0;
                    for (int k = 0; k < 4; k++) {
                        int ny = i + dy[k];
                        int nx = j + dx[k];

                        // 외부공기일때만 체크
                        if (map[ny][nx] == 2) {
                            cnt++;
                        }
                    }

                    // 외부공기 2회이상 접촉시 치즈 삭제
                    if (cnt >= 2) {
                        map[i][j] = 0;
                        cheese--;
                    }
                }
            }
        }
    }
}

//public class Main {
//    public static void main(String[] args) throws IOException {
//        new B2638().solution();
//    }
//}
