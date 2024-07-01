package sol.jinhoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제: (B16926)
 * 풀이: 구현, R 만큼 배열을 회전 + Math.min(N, M) 으로 배열 내부 회전
 * 메모리: 31780kb
 * 시간: 712ms
 */
public class B16926 {

    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] square = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                square[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int rotation = Math.min(N, M) / 2; // 사각형 내부에서 돌아가는 횟수

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < rotation; j++) {
                int last = square[j][j]; // 맨 마지막에 넣는 배열 원소

                // 윗줄
                for (int k = j + 1; k < M - j; k++) {
                    square[j][k - 1] = square[j][k];
                }

                // 오른쪽
                for (int k = j + 1; k < N - j; k++) {
                    square[k - 1][M - j - 1] = square[k][M - j - 1];
                }

                // 아랫줄
                for (int k = M - j - 1; k > j; k--) {
                    square[N - j - 1][k] = square[N - j - 1][k - 1];
                }

                // 왼쪽
                for (int k = N - j - 1; k > j; k--) {
                    square[k][j] = square[k - 1][j];
                }

                square[j + 1][j] = last;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                result.append(square[i][j]).append(" ");
            }
            result.append("\n");
        }

        System.out.println(result);
    }
}

//public class Main {
//    public static void main(String[] args) throws IOException {
//        new B16926().solution();
//    }
//}
