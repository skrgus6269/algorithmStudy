package sol.jinhoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제: (B17144)
 * 풀이: 구현(2차원배열)
 * 메모리: 32892kb
 * 시간: 332ms
 */
public class B17144 {

    int[][] arr;
    int air1, air2;
    int R, C, T;

    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        arr = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 공기청정기 위치 찾기
        for (int i = 0; i < R; i++) {
            if (arr[i][0] == -1) {
                air1 = i;
                air2 = i + 1;
                break;
            }
        }

        // T 초 만큼 반복
        for (int time = 0; time < T; time++) {
            arr = spreadDust();
            onAir();
        }

        int sum = 0;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sum += arr[i][j];
            }
        }

        System.out.println(sum + 2); // 공기 청정기 값 더하기
    }

    int[] dy = {1, -1, 0, 0};
    int[] dx = {0, 0, 1, -1};

    int[][] spreadDust() {
        // 미세먼지 확산
        int[][] tempArr = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (arr[i][j] == -1) {
                    tempArr[i][j] = -1;
                    continue;
                }
                tempArr[i][j] += arr[i][j];
                for (int k = 0; k < 4; k++) {
                    int nx = j + dx[k];
                    int ny = i + dy[k];

                    if (ny >= 0 && ny < R && nx >= 0 && nx < C && arr[ny][nx] != -1) {
                        tempArr[ny][nx] += (arr[i][j] / 5);
                        tempArr[i][j] -= (arr[i][j] / 5);
                    }
                }
            }
        }
        return tempArr;
    }

    void onAir() {
        int top = air1; // 반시계 방향으로 진행

        for (int x = top - 1; x > 0; x--) {
            arr[x][0] = arr[x - 1][0];
        }

        for (int y = 0; y < C - 1; y++) {
            arr[0][y] = arr[0][y + 1];
        }

        for (int x = 0; x < top; x++) {
            arr[x][C - 1] = arr[x + 1][C - 1];
        }

        for (int y = C - 1; y > 1; y--) {
            arr[top][y] = arr[top][y - 1];
        }

        arr[top][1] = 0;

        int bottom = air2; //시계방향으로 진행

        for (int x = bottom + 1; x < R - 1; x++) {
            arr[x][0] = arr[x + 1][0];
        }

        for (int y = 0; y < C - 1; y++) {
            arr[R - 1][y] = arr[R - 1][y + 1];
        }

        for (int x = R - 1; x > bottom; x--) {
            arr[x][C - 1] = arr[x - 1][C - 1];
        }

        for (int y = C - 1; y > 1; y--) {
            arr[bottom][y] = arr[bottom][y - 1];
        }

        arr[bottom][1] = 0;
    }
}

//public class Main {
//    public static void main(String[] args) throws IOException {
//        new B17144().solution();
//    }
//}
