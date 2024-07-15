package sol.jinhoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제: (B3109)
 * 풀이: DFS + 그리디
 * 1. 최대한 위로 길을 선택한다. 최대한 위로만 길은 선택한 경우가 최선의 수 이다.
 * 2. DFS 로 탐색하며 우상단-중단-우하단 순으로 탐색을 진행한다.
 * 3. 도착했다면 isFished = true 로 설정하여 더 이상 탐색을 진행하지 않게하여 지나오길을 그대로 남겨둔다.
 * 메모리: 59572kb
 * 시간: 460ms
 */
public class B3109 {

    int R;
    int C;
    int[][] map;
    boolean[][] isVisited;
    int result;
    int[] dy = {-1, 0, 1};
    boolean isFinished;

    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        isVisited = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                map[i][j] = temp[j];
            }
        }

        for (int i = 0; i < R; i++) {
            isFinished = false;
            isVisited[i][0] = true;
            dfs(0, i);
        }

        System.out.println(result);
    }

    private void dfs(int x, int y) {

        // 본인집 도착
        if (x == C - 1) {
            result++;
            isFinished = true;
            return;
        }

        for (int i = 0; i < 3; i++) {
            int nextY = y + dy[i];
            int nextX = x + 1;
            if (nextY >= 0 && nextY < R && map[nextY][nextX] == '.' && !isVisited[nextY][nextX] && !isFinished) {
                isVisited[nextY][nextX] = true;
                dfs(nextX, nextY);
            }
        }
    }
}

//public class Main {
//    public static void main(String[] args) throws IOException {
//        new B3109().solution();
//    }
//}
