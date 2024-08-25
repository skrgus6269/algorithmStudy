import java.util.Scanner;

/**
 * 문제: 2×n 타일링 2
 * 메모리: 12884 kb
 * 시간: 88 ms
 * 풀이: dp 사용
 */
public class B_11727 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] dp = new int[N+2];

        dp[1] = 1;
        dp[2] = 3;

        for(int i = 3; i <= N; i++) {
            // (뒤에) |가 추가된 경우 + ㅡ2개와 ㅁ가 추가된 경우
            dp[i] = (dp[i-1] + 2 * dp[i-2]) % 10007;
        }

        System.out.println(dp[N]);
    }
}
