import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제: 징검다리 건너기 (large)
 * 메모리: 13076 kb
 * 시간: 156 ms
 * 풀이: dp 사용
 */
public class B_22871 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[N+1];
        long[] stones = new long[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < N+1; i++) {
            stones[i] = Long.parseLong(st.nextToken());
        }

        dp[1] = 0;
        for(int j = 2; j < N+1; j++) {  // 오른쪽 돌
            dp[j] = Long.MAX_VALUE;
            for(int i = 1; i < j; i++) {    // 왼쪽 돌
                dp[j] = Math.min(dp[j], Math.max(dp[i], (j - i) * (1 + Math.abs(stones[i] - stones[j]))));
            }
        }

        System.out.println(dp[N]);
    }
}
