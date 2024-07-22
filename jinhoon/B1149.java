package sol.jinhoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제: RGB 거리 (B1149)
 * 풀이: dp
 * 1. 2차원 dp 에서 y축은 집의 번호, x축은 R,G,B 를 가리킨다. dp[3][0] 이면 3번째집에서 R(빨강)을 칠할때의 최솟값을 가리킨다.
 * 2. 집마다 각 색깔(R,G,B)별로 최소비용을 계산해나간다.
 * 메모리: 14580kb
 * 시간: 152ms
 */
public class B1149 {

    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N + 1][3];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int G = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + R;
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + G;
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + B;
        }

        System.out.println(Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2])));
    }
}

//public class Main {
//    public static void main(String[] args) throws IOException {
//        new B1149().solution();
//    }
//}
