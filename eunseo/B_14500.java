import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제: 테트로미노
 * 메모리: 31312 kb
 * 시간: 568 ms
 * 풀이: dfs, 사방탐색 사용
 */
public class B_14500 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int result, N, M;
    static int[][] paper;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        paper = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        result = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, paper[i][j]);
                visited[i][j] = false;
            }
        }

        System.out.println(result);
    }

    static private void dfs(int x, int y, int count, int sum) {
        if(count == 4) {
            result = Math.max(result, sum);
            return;
        }

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny]) continue;

            // 보라색(ㅗ) 테트로미노 만들기 위해 2번째 칸에서 탐색 한번 더 진행
            if(count == 2) {
                visited[nx][ny] = true;
                dfs(x, y, count+1, sum + paper[nx][ny]);
                visited[nx][ny] = false;
            }

            visited[nx][ny] = true;
            dfs(nx, ny, count+1, sum + paper[nx][ny]);
            visited[nx][ny] = false;
        }
    }
}
