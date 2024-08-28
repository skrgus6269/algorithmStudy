package sol.jinhoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 문제: (B1987)
 * 풀이: BFS
 * 메모리: 300796kb
 * 시간: 2012ms
 */
public class B1987 {

    int R, C;
    char[][] map;
    boolean[][] visit;
    Set<Character> check;
    int result;

    public void solution() throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        visit = new boolean[R][C];
        check = new HashSet<>();

        check.add(map[0][0]);
        dfs(1, 0, 0);
        System.out.println(result);
    }

    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};

    private void dfs(int count, int y, int x) {

        if (count > result) {
            result = count;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < C && ny >= 0 && ny < R) {
                if (!check.contains(map[ny][nx])) {
                    check.add(map[ny][nx]);
                    dfs(count + 1, ny, nx);
                    check.remove(map[ny][nx]);
                }
            }
        }
    }
}

//public class Main {
//    public static void main(String[] args) throws IOException {
//        new B1987().solution();
//    }
//}
