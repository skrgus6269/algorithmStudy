package sol.jinhoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제: 퇴사2 (B15486)
 * 풀이: dp
 * 메모리: 315848kb
 * 시간: 728ms
 */
public class B15486 {

    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N + 1];
        int[] P = new int[N + 1];
        int[] dp = new int[N + 2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        int max = -1;
        int result = 0;
        for (int i = 1; i <= N; i++) {
            max = Math.max(max, dp[i]);

            int nextDay = i + T[i];
            if (nextDay < N + 2) {
                dp[nextDay] = Math.max(dp[nextDay], max + P[i]);
                result = Math.max(result, dp[nextDay]);
            }
        }

        System.out.println(result);
    }
}

//public class Main {
//    public static void main(String[] args) throws IOException {
//        new B15486().solution();
//    }
//}
