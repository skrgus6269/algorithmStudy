import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제: 알파벳
 * 메모리: 12428 kb
 * 시간: 884 ms
 * 풀이: dfs 사용
 */
public class B_1987 {
    static int R, C, result;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[] visited;
    static char[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];
        visited = new boolean[26];  // 알파벳 A-Z는 26개이므로 크기를 26으로 설정
        result = 0;

        for(int i = 0; i < R; i++) {
            String str = br.readLine();
            for(int j = 0; j < C; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        visited[board[0][0] - 'A'] = true;
        dfs(0, 0, 1);

        System.out.println(result);
    }

    private static void dfs(int x, int y, int depth) {
        result = Math.max(depth, result);

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= R || ny >= C) continue;

            if (visited[board[nx][ny] - 'A']) continue;

            visited[board[nx][ny] - 'A'] = true;
            dfs(nx, ny, depth + 1);
            visited[board[nx][ny] - 'A'] = false;
        }
    }
}
