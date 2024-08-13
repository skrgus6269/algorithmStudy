package sol.jinhoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제: 1의 개수 세기 (B9527)
 * 풀이: 수학, 누적합, 비트마스킹
 * 메모리: 14200kb
 * 시간: 100ms
 */
public class B9527 {

    long[] dp = new long[55];
    long A, B;
    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        dp[0] = 1;
        for (int i = 1; i < 55; i++) {
            dp[i] = (dp[i - 1] << 1) + (1L << i);
        }

        System.out.println(count(B) - count(A - 1));
    }

    private long count(long num) {
        long ans = num & 1;
        for (int i = 54; i > 0; i--) {
            if ((num & (1L << i)) != 0L) {
                ans += dp[i - 1] + (num - (1L << i) + 1);
                num -= (1L << i);
            }
        }
        return ans;
    }
}

//public class Main {
//    public static void main(String[] args) throws IOException {
//        new B9527().solution();
//    }
//}
