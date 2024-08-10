import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    BOJ 10026
    java 11 / 16916 KB / 140 ms
 */
public class Main {

    static int N;
    static boolean[][] visited;
    static boolean[][] visited2;
    static char[][] picture;
    static int result1, result2;
    static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        visited = new boolean[N][N];
        visited2 = new boolean[N][N];
        picture = new char[N][N];

        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                picture[i][j] = input[j];
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    result1++;
                    dfs(1, i, j);
                }

                if (!visited2[i][j]) {
                    result2++;
                    dfs(2, i, j);
                }
            }
        }

        System.out.printf("%d %d", result1, result2);
    }

    static void dfs(int type, int x, int y) {
        int nx, ny;
        if (type == 1) {
            visited[x][y] = true;
            for (int i = 0; i < 4; i++) {
                nx = x + dx[i];
                ny = y + dy[i];
                if (!isSafe(nx, ny)) {
                    continue;
                }

                if (visited[nx][ny]) {
                    continue;
                }

                if (picture[nx][ny] == picture[x][y]) {
                    dfs(type, nx, ny);
                }
            }

        } else {
            visited2[x][y] = true;
            for (int i = 0; i < 4; i++) {
                nx = x + dx[i];
                ny = y + dy[i];
                if (!isSafe(nx, ny)) {
                    continue;
                }

                if (visited2[nx][ny]) {
                    continue;
                }

                if (picture[x][y] == picture[nx][ny]
                    || (picture[x][y] == 'R' && picture[nx][ny] == 'G')
                    || (picture[x][y] == 'G' && picture[nx][ny] == 'R')) {
                    dfs(type, nx, ny);
                }
            }
        }
    }

    static boolean isSafe(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }

}
