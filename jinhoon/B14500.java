package sol.jinhoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제: 테트로미노 (B14500)
 * 풀이: 노가다 그 자체
 * 메모리: 33364kb
 * 시간: 504ms
 */
public class B14500 {

    int[] dx1 = {1, 0, 1, 1, 0, -1, 0, 1, 0, -1, -1, 1, 0, -1, 0, 1, 0, 0, -1, 0, 1, -1, 0};
    int[] dy1 = {0, 1, 0, 0, 1, 0, -1, 0, 1, 0, -2, 0, -2, -1, 1, 0, 1, -1, 0, -1, 0, 0, 1};
    int[] dx2 = {2, 0, 0, 2, 0, -2, 0, 1, 1, -1, -1, 1, 0, -1, 0, 2, 0, 0, -2, 1, 1, -1, -1};
    int[] dy2 = {0, 2, 1, 0, 2, 0, -2, -1, 1, 1, -1, 1, -1, 0, 2, 0, 2, -2, 0, -1, 1, -1, 1};
    int[] dx3 = {3, 0, 1, 2, -1, -2, 1, 2, 1, -2, 0, 2, 1, -2, -1, 2, 1, -1, -2, 1, 2, -2, -1};
    int[] dy3 = {0, 3, 1, 1, 2, -1, -2, -1, 2, 1, -1, 0, -1, 0, 1, -1, 2, -2, 1, -2, 1, -1, 2};

    int N, M;
    int[][] map;

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
            }
        }

        int score = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                for (int k = 0; k < 23; k++) {
                    int nx1 = j + dx1[k];
                    int ny1 = i + dy1[k];
                    int nx2 = j + dx2[k];
                    int ny2 = i + dy2[k];
                    int nx3 = j + dx3[k];
                    int ny3 = i + dy3[k];

                    if (check(nx1, ny1) && check(nx2, ny2) && check(nx3, ny3)) {
                        score = Math.max(score, map[i][j] + map[ny1][nx1] + map[ny2][nx2] + map[ny3][nx3]);
                    }
                }
            }
        }

        System.out.println(score);
    }

    private boolean check(int x, int y) {
        return (x >= 0 && x < M && y >= 0 && y < N);
    }
}

//public class Main {
//    public static void main(String[] args) throws IOException {
//        new B14500().solution();
//    }
//}
