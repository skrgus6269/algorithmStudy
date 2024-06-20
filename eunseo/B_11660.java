import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * (0, 0)~(x, y)만큼 누적합 구하고, 구하는 위치에 맞게 뺀다.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] board = new int[N+1][N+1];

        for(int i = 1; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j < N+1; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                board[i][j] += board[i][j-1];
            }
        }

        for(int i = 1; i < N+1; i++) {
            for(int j = 1; j < N+1; j++) {
                board[i][j] += board[i-1][j];
            }
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            System.out.println(board[x2][y2] - board[x1-1][y2] - board[x2][y1-1] + board[x1-1][y1-1]);
        }
    }
}
