import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    java 11 / 32280KB / 308ms
 */
public class Main {

    static int R, C, T;
    static int[][] room;
    static int topAirConditioner = -1;
    static int bottomAirConditioner = -1;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        room = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());

                if (room[i][j] < 0 && topAirConditioner == -1) {
                    topAirConditioner = i;
                    bottomAirConditioner = i + 1;
                }
            }
        }

        for (int i = 0; i < T; i++) {
            room = spreadFineDust();
            cleanAir();
        }

        System.out.println(sumFineDust());
    }

    static int[][] spreadFineDust() {
        int[][] temp = new int[R][C];

        for (int x = 0; x < R; x++) {
            for (int y = 0; y < C; y++) {
                if (room[x][y] == -1) {
                    temp[x][y] = -1;
                    continue;
                }

                temp[x][y] += room[x][y];
                int spreadAmount = room[x][y] / 5;

                for (int direction = 0; direction < 4; direction++) {
                    int nx = x + dx[direction];
                    int ny = y + dy[direction];

                    if (nx < 0 || R <= nx || ny < 0 || C <= ny) {
                        continue;
                    }
                    if (room[nx][ny] == -1) {
                        continue;
                    }

                    temp[nx][ny] += spreadAmount;
                    temp[x][y] -= spreadAmount;
                }
            }
        }

        return temp;
    }

    static void cleanAir() {

        // 위쪽 공기청정기 반시계방향으로 순환
        for (int x = topAirConditioner - 1; x > 0; x--) {
            room[x][0] = room[x - 1][0];
        }

        for (int y = 0; y < C - 1; y++) {
            room[0][y] = room[0][y + 1];
        }

        for (int x = 0; x < topAirConditioner; x++) {
            room[x][C - 1] = room[x + 1][C - 1];
        }

        for (int y = C - 1; y > 1; y--) {
            room[topAirConditioner][y] = room[topAirConditioner][y - 1];
        }

        room[topAirConditioner][1] = 0;

        // 아래쪽 공청정기는 시계방향으로 순환
        for (int x = bottomAirConditioner + 1; x < R - 1; x++) {
            room[x][0] = room[x + 1][0];
        }

        for (int y = 0; y < C - 1; y++) {
            room[R - 1][y] = room[R - 1][y + 1];
        }

        for (int x = R - 1; x > bottomAirConditioner; x--) {
            room[x][C - 1] = room[x - 1][C - 1];
        }

        for (int y = C - 1; y > 1; y--) {
            room[bottomAirConditioner][y] = room[bottomAirConditioner][y - 1];
        }

        room[bottomAirConditioner][1] = 0;
    }


    static int sumFineDust() {
        int sum = 0;

        for (int x = 0; x < R; x++) {
            for (int y = 0; y < C; y++) {
                if (room[x][y] == -1) {
                    continue;
                }
                sum += room[x][y];
            }
        }

        return sum;
    }
}
