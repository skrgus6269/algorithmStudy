import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] prefixSum = new int[n][n + 1];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            /*
             * 각 행의 구간합을 미리 계산해서 저장
             */
            for (int j = 1; j <= n; j++) {
                prefixSum[i][j] = prefixSum[i][j - 1] + Integer.parseInt(st.nextToken());
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int result = 0;

            /*
             * 미리 계산한 구간합을 이용해서 각 행마다 구간합을 계산하여 SUM
             * 0 1 2   3
             * 0 a a+b a+b+c -> 2 ~ 3의 구간합은 3(a+b+c) - 2-1(a) = b+c
             */
            for (int x = x1 - 1; x < x2; x++) {
                result += prefixSum[x][y2] - prefixSum[x][y1 - 1];
            }

            sb.append(result).append("\n");
        }

        System.out.print(sb.toString());
    }
}
