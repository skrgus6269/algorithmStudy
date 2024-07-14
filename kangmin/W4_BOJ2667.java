import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
    java11/ 14228 KB / 104ms
 */
public class Main {

    static int n;
    static int[][] map;
    static boolean[][] visited;
    static StringBuilder result;
    static List<Integer> counts = new ArrayList<>();
    static int count = 1;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        result = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1
                    && !visited[i][j]) {
                    dfs(i, j);
                    counts.add(count);
                    count = 1;
                }
            }
        }

        result.append(counts.size()).append("\n");
        Collections.sort(counts);
        for (int num : counts) {
            result.append(num).append("\n");
        }

        System.out.print(result);

    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || n <= nx || ny < 0 || n <= ny) {
                continue;
            }

            if (map[nx][ny] == 0) {
                continue;
            }

            if (visited[nx][ny]) {
                continue;
            }
            count++;
            dfs(nx, ny);
        }
    }

}
