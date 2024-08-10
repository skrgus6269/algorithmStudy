import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 문제: LCS
 * 메모리: 16072 kb
 * 시간: 104 ms
 * 풀이: 최장 공통 부분수열(Longest Common Subsequence) 알고리즘 사용 (!= 최장 공통 문자열(Longest Common Substring)),
 *      dp 활용
 *      참고) https://velog.io/@jeongbeom4693/JAVA-LCS-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98
 */
public class B_9251 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String A = br.readLine();
        String B = br.readLine();

        int[][] dp = new int[A.length()+1][B.length()+1];

        for(int i = 1; i <= A.length(); i++) {
            for(int j = 1; j <= B.length(); j++) {
                if(A.charAt(i-1) == B.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1]+1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        System.out.println(dp[A.length()][B.length()]);
    }
}
