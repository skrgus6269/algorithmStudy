package sol.jinhoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문제: 2xn 타일링2 (B11727)
 * 풀이: dp
 * 메모리: 14348kb
 * 시간: 104ms
 */
public class B11727 {

    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] dp = new long[n + 2];
        dp[1] = 1;
        dp[2] = 3;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + 2 * dp[i - 2]) % 10007;
        }

        System.out.println(dp[n]);
    }
}

//public class Main {
//    public static void main(String[] args) throws IOException {
//        new B11727().solution();
//    }
//}
