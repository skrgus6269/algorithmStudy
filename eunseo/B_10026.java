import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문제: 적록색약
 * 메모리: 13244 kb
 * 시간: 136 ms
 * 풀이: dfs 사용
 */
public class B_10026 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int count1 = 0;
    static int count2 = 0;
    static int N;
    static String[][] grid;
    static boolean[][] visited;
    static class Pos {
        int x, y;
        String color;

        public Pos(int x, int y, String color) {
            super();
            this.x = x;
            this.y = y;
            this.color = color;
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        grid = new String[N][N];
        visited = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            String[] str = br.readLine().split("");
            for(int j = 0; j < N; j++) {
                grid[i][j] = str[j];
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    count1++;
                    dfs(i, j, grid[i][j]);
                }
            }
        }

        visited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(grid[i][j].equals("G")) {
                    grid[i][j] = "R";
                }
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    count2++;
                    dfs(i, j, grid[i][j]);
                }
            }
        }

        System.out.print(count1 + " " +count2);
    }

    private static void dfs(int x, int y, String color) {
        visited[x][y] = true;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if(!grid[nx][ny].equals(color)) continue;
            if(visited[nx][ny]) continue;

            dfs(nx, ny, color);
        }
    }
}
