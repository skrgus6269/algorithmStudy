import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    BOJ 1932
    java 11 / 26064 KB / 240 ms
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int result = Integer.MIN_VALUE;
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++) {
                dp[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                if (j == 1) {
                    dp[i][j] += dp[i - 1][j];
                } else if (j == N) {
                    dp[i][j] += dp[i - 1][j - 1];
                } else {
                    dp[i][j] += Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            result = Math.max(result, dp[N][i]);
        }

        System.out.print(result);
    }


}
