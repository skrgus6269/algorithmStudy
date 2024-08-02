import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
    BOJ 7569
    java 11 / 128500 KB / 604 ms
 */
public class Main {

    static class Tomato {
        int x;
        int y;
        int z;
        int day;

        public Tomato(int x, int y, int z, int day) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.day = day;
        }
    }

    static int N, M, H;
    static int[][][] storage;
    static boolean[][][] isVisited;
    static Queue<Tomato> queue = new LinkedList<>();
    static int[] dx = {1, 0, -1, 0, 0, 0}, dy = {0, 1, 0, -1, 0, 0}, dz = {0, 0, 0, 0, -1, 1};
    static int tomatoCount = 0;
    static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        storage = new int[N][M][H];
        isVisited = new boolean[N][M][H];

        for (int k = 0; k < H; k++) {
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    int input = Integer.parseInt(st.nextToken());
                    storage[i][j][k] = input;
                    if (input == 1) {
                        queue.add(new Tomato(i, j, k, 0));
                        isVisited[i][j][k] = true;
                    }
                    if (0 == input) {
                        tomatoCount++;
                    }
                }
            }
        }

        bfs();
        if (0 < tomatoCount) {
            System.out.println("-1");
        } else {
            System.out.println(result);
        }

    }

    public static void bfs() {
        while (!queue.isEmpty()) {
            Tomato curTomato = queue.poll();
            result = Math.max(result, curTomato.day);
            for (int i = 0; i < 6; i++) {
                int nx = curTomato.x + dx[i];
                int ny = curTomato.y + dy[i];
                int nz = curTomato.z + dz[i];

                if (isInStorage(nx, ny, nz)
                    && !isVisited[nx][ny][nz]
                    && storage[nx][ny][nz] != -1) {
                    tomatoCount--;
                    queue.add(new Tomato(nx, ny, nz, curTomato.day + 1));
                    isVisited[nx][ny][nz] = true;
                }
            }
        }
    }

    public static boolean isInStorage(int x, int y, int z) {
        return 0 <= x && x < N && 0 <= y && y < M && 0 <= z && z < H;
    }

}

