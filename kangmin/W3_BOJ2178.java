import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
    java 11 / 14756 KB / 108ms
 */
public class Main {

    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i<n; i++) {
            String input = br.readLine();
            for (int j = 0; j<m; j++) {
             map[i][j] = input.charAt(j) - '0';
            }
        }

        bfs(0,0);
        System.out.println(map[n-1][m-1]);
    }

    static void bfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();

        queue.offer(new Point(x,y));
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            Point currentPoint = queue.poll();


            for (int i = 0; i<4; i++) {
                int nx = currentPoint.x + dx[i];
                int ny = currentPoint.y + dy[i];

                if (nx < 0 || n <= nx || ny < 0 || m <= ny) {
                    continue;
                }

                if (0 == map[nx][ny]) {
                    continue;
                }

                if (visited[nx][ny]) {
                    continue;
                }
                queue.offer(new Point(nx, ny));
                map[nx][ny] = map[currentPoint.x][currentPoint.y] + 1;
                visited[nx][ny] = true;
            }
        }
    }

}
