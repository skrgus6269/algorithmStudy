import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/*
 * https://www.acmicpc.net/source/79776832
 * java8 / 131876 KB / 760 ms /
 */
public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw=  new BufferedWriter(new OutputStreamWriter(System.out));
    StringTokenizer st = new StringTokenizer(bf.readLine());
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int mp[][] = new int[N+1][N+1];
    int dp[][] = new int[N+1][N+1];
    /*
     * step 1. DP 배열 채우기 dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + mp[i][j];
     * */
    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(bf.readLine());
      for (int j = 1; j <= N; j++) {
        dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + Integer.parseInt(st.nextToken());
      }
    }
    /* step 2. 쿼리 연산 x1,y1,x2,y2
     *  answer = dp[x2][y2] - dp[x2][y1-1] - dp[x1-1][y2] + dp[x1-1][y1-1]
     * */
    int input[] = new int[4];
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(bf.readLine());
      for (int j = 0; j < 4; j++) {
        input[j] = Integer.parseInt(st.nextToken());
      }
      sb.append(dp[input[2]][input[3]] - dp[input[0]-1][input[3]] - dp[input[2]][input[1]-1] + dp[input[0]-1][input[1]-1]).append("\n");
    }
    bw.write(sb.toString());
    bw.flush();
    bw.close();
  }
}