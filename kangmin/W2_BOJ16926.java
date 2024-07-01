import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    java 11 / 30660KB / 740ms
 */
public class Main {

    static int n, m, r;
    static int[][] inputArr;
    static int rotateCount;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        inputArr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                inputArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        rotateCount = Math.min(n, m) / 2;

        for (int i = 0; i < r; i++) {
            rotate();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(inputArr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }

    static void rotate() {
        for (int i = 0; i < rotateCount; i++) {
            int x = i;
            int y = i;
            int idx = 0;
            // 시작 지점 저장
            int start = inputArr[x][y];
            
            // 한쪽 방향씩 돌림
            while (idx < 4) {
                int nx = x + dx[idx];
                int ny = y + dy[idx];

                // 범위 벗어나면 방향 전환
                if (nx < n - i && ny < m - i && i <= nx && i <= ny) {
                    inputArr[x][y] = inputArr[nx][ny];
                    x = nx;
                    y = ny;
                } else {
                    idx++;
                }
            }
            inputArr[i + 1][i] = start;
        }
    }
}
