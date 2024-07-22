import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제: 평범한 배낭
 * 메모리: 51784 kb
 * 시간: 156 ms
 * 풀이: 부분조합 사용 -> 시간 조과
 *      동적계획법(dp) Bottom-up 방식 사용
 */
public class B_12865 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] W = new int[N+1];   // 물품의 수
        int[] V = new int[K+1];   // 버틸 수 있는 무게
        int[][] dp = new int[N+1][K+1];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());    // 물건의 무게
            V[i] = Integer.parseInt(st.nextToken());    // 물건의 가치
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= K; j++) {
                if(W[i] > j) {
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-W[i]] + V[i]);
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}
