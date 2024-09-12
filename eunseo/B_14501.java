import java.io.*;
import java.util.*;

/**
 * 문제: 퇴사
 * 메모리: 11560 kb
 * 시간: 11560 ms
 * 풀이: dp 활용 (상담 완료 한 금액을 미리 더해 나감)
 */
public class B_14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] T = new int[N];
        int[] P = new int[N];
        int[] dp = new int[N+1];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++) {
            // 날짜가 넘어가는지 체크
            if(i+T[i] <= N) {
                // (현재날짜 + 상담완료 기간)날짜에 저장된 수입 vs (오늘 이전까지 최대 수입 + 오늘 버는 수입)
                dp[i+T[i]] = Math.max(dp[i+T[i]], dp[i]+P[i]);
            }

            // 상담이 진행되는 중에도 0원이 아닌 이전의 최대 금액임(현재와 다음날 중 큰 값으로 일단 다음날을 지정해줌)
            dp[i+1] = Math.max(dp[i], dp[i+1]);
        }

        System.out.println(dp[N]);
    }
}
