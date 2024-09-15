import java.io.*;
import java.util.*;

/**
 * 문제: 연구소
 * 메모리: 294212 kb
 * 시간: 640 ms
 * 풀이: dfs, bfs 사용
 */
public class B_14502 {
    static int N, M, result;
    static int[][] map, tempMap;
    static List<int[]> virus;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        tempMap = new int[N][M];
        virus = new LinkedList<>();
        result = 0;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 2) {
                    virus.add(new int[] {i, j});
                }
            }
        }

        setWall(0);

        System.out.println(result);
    }

    static private void setWall(int cnt) {
        if(cnt == 3) {
            copyMap();
            checkVirus();
            result = Math.max(result, checkSafeZone());
            return;
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 0) {
                    map[i][j] = 1;
                    setWall(cnt+1);
                    map[i][j] = 0;
                }
            }
        }
    }

    static private void copyMap() {
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < M; j++) {
//                tempMap[i][j] = map[i][j];
//            }
//        }

        // 현재 맵의 상태를 복사
        for (int i = 0; i < N; i++) {
            System.arraycopy(map[i], 0, tempMap[i], 0, M);
        }
    }

    static private void checkVirus() {
        Queue<int[]> queue = new LinkedList<>();
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        for(int i = 0; i < virus.size(); i++) {
            queue.offer(virus.get(i));

            while(!queue.isEmpty()) {
                int[] current = queue.poll();

                for(int j = 0; j < 4; j++) {
                    int nx = current[0] + dx[j];
                    int ny = current[1] + dy[j];

                    if(nx < 0 || ny < 0 || nx >= N || ny >= M || tempMap[nx][ny] != 0) continue;

                    tempMap[nx][ny] = 2;
                    queue.offer(new int[] {nx, ny});
                }
            }

        }
    }

    static private int checkSafeZone() {
        int count = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(tempMap[i][j] == 0) {
                    count++;
                }
            }
        }

        return count;
    }
}
