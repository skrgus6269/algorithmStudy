package sol.jinhoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 달팽이숫자 D2
 * 풀이: 벽, 숫자를 만나면 방향전환을 해서 숫자를 채움
 * 메모리: kb
 * 시간: ms
 */
public class S1954 {

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int test = 1; test <= T; test++) {

            int N = Integer.parseInt(br.readLine());
            int[][] square = new int[N][N];

            int x = 0;
            int y = 0;
            int d = 0;
            for (int i = 1; i <= N * N; i++) {
                square[y][x] = i;
                if (x + dx[d] == N
                        || x + dx[d] == -1
                        || y + dy[d] == N
                        || y + dy[d] == -1
                        || square[y + dy[d]][x + dx[d]] != 0) {
                    // 벽에 부딪혔거나, 숫자를 만났다면 방향 전환
                    d = (d + 1) % 4;
                }

                x += dx[d];
                y += dy[d];
            }

            result.append("#").append(test).append("\n");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    result.append(square[i][j]).append(" ");
                }
                result.append("\n");
            }
        }

        System.out.println(result);
    }
}

