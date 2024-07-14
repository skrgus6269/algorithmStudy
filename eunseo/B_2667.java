import java.util.*;
import java.io.*;

/**
 * 문제: 단지번호붙이기
 * 메모리: 11788 kb
 * 시간: 84 ms
 * 풀이: bfs 사용
 */
public class B_2667 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 0) continue;

                Queue<int[]> q = new LinkedList<>();
                q.offer(new int[] {i, j});
                map[i][j] = 0;

                int count = 1;
                while(!q.isEmpty()) {
                    int[] current = q.poll();

                    for(int k = 0; k < 4; k++) {
                        int nx = current[0] + dx[k];
                        int ny = current[1] + dy[k];

                        if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                        if(map[nx][ny] == 1) {
                            q.offer(new int[] {nx, ny});
                            map[nx][ny] = 0;
                            count++;
                        }
                    }
                }

                result.add(count);
            }
        }

        Collections.sort(result);

        System.out.println(result.size());
        for(int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}
