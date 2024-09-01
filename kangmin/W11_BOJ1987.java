import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    BOJ 1987
    java 11 / 297744 KB / 2420 ms
 */
public class Main {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[][] alphabet;
    static int R, C;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        R = Integer.parseInt(s[0]);
        C = Integer.parseInt(s[1]);
        alphabet = new char[R][C];
        for (int i = 0; i < R; i++) {
            alphabet[i] = br.readLine().toCharArray();
        }
        dfs(0, 0, String.valueOf(alphabet[0][0]));
        System.out.println(answer);


    }

    public static void dfs(int x, int y, String path) {
        answer = Math.max(answer, path.length());
        for (int i = 0; i < 4; i++) {
            int next_x = x + dx[i];
            int next_y = y + dy[i];
            if (isIn(next_x, next_y)) continue;
            if (path.indexOf(alphabet[next_x][next_y]) != -1) continue;
            dfs(next_x, next_y, path + alphabet[next_x][next_y]);
        }
    }


    public static boolean isIn(int x, int y) {
        return x < 0 || x >= R || y < 0 || y >= C;
    }
}
