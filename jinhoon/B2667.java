package sol.jinhoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 문제: (B2667)
 * 풀이: bfs
 * 1. 집(1)만을 찾아서 동네에 있는 집의 총 개수를 반환하는 bfs 를 만든다.
 * 2. 맵의 모든 좌표를 순회하여, 집이 존재하고 방문하지 않은 경우에만 bfs 를 체크해 동네의 집개수의 값을 얻고 동네 개수를 증가시킨다..
 * 3. 집 개수를 오름차순으로 정렬한다.
 * 메모리: 14204kb
 * 시간: 108ms
 */
public class B2667 {

    int N;
    int[][] map;
    int[][] isVisited;
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    public void solution() throws IOException {

        int count = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        isVisited = new int[N][N];
        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = row.charAt(j) - '0';
            }
        }

        List<Integer> homes = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && isVisited[i][j] == 0) {
                    homes.add(bfs(i, j));
                    count++;
                }
            }
        }

        Collections.sort(homes);
        result.append(count).append("\n");
        for (Integer home : homes) {
            result.append(home).append("\n");
        }

        System.out.println(result);
    }

    private int bfs(int y, int x) {
        int home = 1;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{y, x});
        isVisited[y][x] = home;

        while (!q.isEmpty()) {

            int[] cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nextY = cur[0] + dy[i];
                int nextX = cur[1] + dx[i];

                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N && map[nextY][nextX] == 1 && isVisited[nextY][nextX] == 0) {
                    isVisited[nextY][nextX] = home++;
                    q.offer(new int[]{nextY, nextX});
                }
            }
        }

        return home;
    }
}

//public class Main {
//    public static void main(String[] args) throws IOException {
//        new B2667().solution();
//    }
//}
