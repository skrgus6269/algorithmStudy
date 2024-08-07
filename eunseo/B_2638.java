import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 문제: 치즈(2638)
 * 메모리: 38440 kb
 * 시간 : 228 ms
 * 풀이: 구현(시뮬레이션), bfs 사용
 */
public class B_2638 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int N, M, cheese;
    static int[][] paper;
    static boolean[][] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        paper = new int[N][M];
        cheese = 0;
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
                if(paper[i][j] == 1) {
                    cheese++;   // 녹아야할 치즈 개수
                }
            }
        }

        int result = 0;
        while(cheese != 0) {
            result ++;
            visited = new boolean[N][M];
            checkOutSide();
            meltCheese();
        }

        System.out.println(result);
    }

    static private void meltCheese() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(paper[i][j] == 1) {
                    int count = 0;
                    for(int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];

                        if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                        // 치즈 중에 외부랑 닿아 있는 치즈
                        if(paper[nx][ny] == 2) {
                            count++;
                        }
                    }

                    // 외부랑 2면 이상 닿아 있으면 치즈 녹임
                    if(count >= 2) {
                        paper[i][j] = 0;
                        cheese--;
                    }
                }
            }
        }
    }

    static private void checkOutSide() {
        Queue<int[]> q = new LinkedList<>();
        // 외부 공기 시작
        // 외부 공기 2, 내부 공기 0, 치즈 1
        q.offer(new int[] {0, 0});
        visited[0][0] = true;
        paper[0][0] = 2;

        while(!q.isEmpty()) {
            int[] current = q.poll();

            for(int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];

                // paper 안에 없고 방문한적이 있고 치즈이면 continue -> 내부 공기는 추가될 수 없음
                if(nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny] || paper[nx][ny] == 1) continue;

                q.offer(new int[] {nx, ny});
                paper[nx][ny] = 2;
                visited[nx][ny] = true;
            }
        }
    }
}
