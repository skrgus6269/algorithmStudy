import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
    java11/ 15436 KB / 132 ms
 */
public class Main {

    static int N;
    static int[][] coloredPaper;
    static int whiteColoredPaper = 0;
    static int blueColoredPaper = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        coloredPaper = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                coloredPaper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        splitColoredPaper(0, 0, N);
        System.out.println(whiteColoredPaper);
        System.out.print(blueColoredPaper);

    }

    static void splitColoredPaper(int x, int y, int size) {
        if (checkColor(x, y, size)
            || size == 1) {
            if (coloredPaper[x][y] == 1) {
                blueColoredPaper++;
            } else if (coloredPaper[x][y] == 0) {
                whiteColoredPaper++;
            }
            return;
        }
        int splitSize = size / 2;
        splitColoredPaper(x, y, splitSize);
        splitColoredPaper(x + splitSize, y, splitSize);
        splitColoredPaper(x, y + splitSize, splitSize);
        splitColoredPaper(x + splitSize, y + splitSize, splitSize);
    }

    static boolean checkColor(int x, int y, int size) {
        int color = coloredPaper[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (color != coloredPaper[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }


}
