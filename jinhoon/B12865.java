package sol.jinhoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제: (B12865)
 * 풀이: dp(2차원배열)
 * 1. 2차원배열 DP 생성(y 축은 배낭의 무게, x 축은 n 번째에 해당하는 아이템가치이다. ex) dp[1][3] 이면 1kg 일때 3번째 아이템을 넣을 당시의 최대가치)
 * 2. 배낭에 물건을 넣을 수 없다면, 이전 값(dp[i][j-1])이 최대가치이다.
 * 3. 배낭에 물건을 넣을 수 있다면  Math.max(이전값(dp[i][j-1]), 물건을 넣었을 경우 해당 물건의 무게를 뺐을 당시의 최대가치와 무게의 가치의 합(dp[i-무게][j-1]+가치)
 * 메모리: 56048kb
 * 시간: 256ms
 */
public class B12865 {

    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] product = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            product[i][0] = Integer.parseInt(st.nextToken());
            product[i][1] = Integer.parseInt(st.nextToken());
        }

        // y 축은 배낭의 무게, x 축은 n번째 아이템
        int[][] dp = new int[K + 1][N + 1];
        for (int i = 1; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                // 물건이 현재 최대 무게 조건보다 이하일때(가방에 넣을 수 있을때)
                if (product[j][0] <= i) {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - product[j][0]][j - 1] + product[j][1]);
                } else {
                    // 가방에 못넣는다면 이전값으로 세팅
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }

        System.out.println(dp[K][N]);
    }
}

//public class Main {
//    public static void main(String[] args) throws IOException {
//        new B12865().solution();
//    }
//}
