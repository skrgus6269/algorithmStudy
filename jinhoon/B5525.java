package sol.jinhoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문제: IOIOI (B5525)
 * 풀이: dp
 * 메모리: 25908kb
 * 시간: 280ms
 */
public class B5525 {

    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        char[] S = br.readLine().toCharArray();

        int[] dp = new int[M];
        int result = 0;

        for (int i = 1; i < M - 1; i++) {
            if (S[i] == 'O' && S[i + 1] == 'I') {
                dp[i + 1] = dp[i - 1] + 1;

                if (dp[i + 1] >= N && S[i - 2 * N + 1] == 'I')
                    result++;
            }
        }

        System.out.println(result);
    }
}

//public class Main {
//    public static void main(String[] args) throws IOException {
//        new B5525().solution();
//    }
//}
