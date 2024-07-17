package sol.jinhoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제: 파이프 옮기기(B17070)
 * 풀이 : dp
 * 1. dp[][][] 첫번째요소 y좌표, 두번째요소 x좌표, 3번째요소 파이프상태(가로, 세로, 대각). dp[1][2][0] 이면 (1,2) 에 파이프가 가로로 놓였을때 최대 가지 수
 * 2. 각 파이프 상태별로 가지 수를 갱신하고 마지막은 총 가지 수의 합이다.
 * 3. 벽이 아닌경우만 계산하며, 대각의 경우 긁히지 않도록 추가로 검사
 * 메모리: 14320kb
 * 시간: 128ms
 */
public class B17070 {

    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 0 : 가로
        // 1 : 세로
        // 2 : 대각
        int[][][] dp = new int[N + 1][N + 1][3];
        dp[1][2][0] = 1;
        for (int i = 1; i <= N; i++) {
            for (int j = 3; j <= N; j++) {
                if (map[i][j] == 0) {
                    dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2];
                    dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2];

                    // 대각선은 주변도 벽이 없어야 한다
                    if (map[i - 1][j] == 0 && map[i][j - 1] == 0) {
                        dp[i][j][2] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
                    }
                }
            }
        }

        System.out.println(dp[N][N][0] + dp[N][N][1] + dp[N][N][2]);
    }
}

//public class Main {
//    public static void main(String[] args) throws IOException {
//        new B17070().solution();
//    }
//}
