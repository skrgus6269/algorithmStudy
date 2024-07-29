package sol.jinhoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문제: LCS (B9251)
 * 풀이: dp
 * 1. 2차원 dp 로 가로 세로 각각 문자열에 해당한다. dp[2][3] 이면 문자열 각각의 부분 문자열 2개, 3개 일때 LCS 가 기록된다.
 * 메모리: 18276kb
 * 시간: 152ms
 */
public class B9251 {

    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] s1 = br.readLine().toCharArray();
        char[] s2 = br.readLine().toCharArray();

        int[][] dp = new int[s1.length + 1][s2.length + 1];

        for (int i = 1; i <= s1.length; i++) {
            for (int j = 1; j <= s2.length; j++) {
                if (s1[i - 1] == s2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        System.out.println(dp[s1.length][s2.length]);
    }
}

//public class Main {
//    public static void main(String[] args) throws IOException {
//        new B9251().solution();
//    }
//}
