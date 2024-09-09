import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    BOJ 22871
    java 11 / 15016 KB / 200 ms
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        long[] stones = new long[N + 1];
        long[] dp = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            stones[i] = Long.parseLong(st.nextToken());
        }

        dp[1] = 0;
        for (int i = 2; i <= N; i++) {
            dp[i] = Long.MAX_VALUE;
            for (int j = 1; j<i; j++) {
                dp[i] = Math.min(dp[i], Math.max(dp[j], (i - j) * (1 + Math.abs(stones[i] - stones[j]))));
            }
        }

        System.out.print(dp[N]);
    }
}
