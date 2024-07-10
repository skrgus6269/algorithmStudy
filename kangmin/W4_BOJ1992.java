import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    java 11 / 14148 KB / 104ms
 */
public class Main {

    static int n;
    static int[][] map;
    static StringBuilder result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        result = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        compressVideo(0, 0, n);
        System.out.println(result);
    }

    static void compressVideo(int curX, int curY, int size) {
        if (isCanCompress(curX, curY, size)) {
            result.append(map[curX][curY]);
            return;
        }

        result.append("(");
        int nextSize = size / 2;
        compressVideo(curX, curY, nextSize);
        compressVideo(curX, curY + nextSize, nextSize);
        compressVideo(curX + nextSize, curY, nextSize);
        compressVideo(curX + nextSize, curY + nextSize, nextSize);
        result.append(")");
    }

    static boolean isCanCompress(int curX, int curY, int size) {
        int value = map[curX][curY];

        for (int i = curX; i < curX + size; i++) {
            for (int j = curY; j < curY + size; j++) {
                if (map[i][j] != value) {
                    return false;
                }
            }
        }

        return true;
    }

}
