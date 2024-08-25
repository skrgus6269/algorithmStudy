import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제: 정수 삼각형
 * 메모리: 23716 kb
 * 시간: 244 ms
 * 풀이: dp 사용
 */
public class B_1932_정수삼각형 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[N][N];
        dp[0][0] = Integer.parseInt(br.readLine());

        int count = 2;
        for(int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < count; j++) {

                dp[i][j] = Integer.parseInt(st.nextToken());
                if(j == 0) {
                    dp[i][j] = dp[i-1][j]+dp[i][j];
                    continue;
                }

                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + dp[i][j];
            }
            count++;
        }

        int result = 0;
        for(int i = 0; i < N; i++) {
            result = Math.max(result, dp[N-1][i]);
        }

        System.out.println(result);
    }
}
