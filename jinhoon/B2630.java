package sol.jinhoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제: (B2630)
 * 풀이: 분할정복
 * 1. 색종이가 하나의 색으로 일치하는지 확인한다.
 * 2. 일치한다면 해당하는 색을 추가하고 해당하지 않는다면 4분면으로 쪼개고 해당 과정을 반복한다.
 * 메모리: 15620kb
 * 시간: 140ms
 */
public class B2630 {

    int N;
    int[][] map;
    int white;
    int blue;

    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cutPaper(0, 0, N);
        System.out.println(white);
        System.out.println(blue);
    }

    private void cutPaper(int y, int x, int size) {

        if (checkPaper(y, x, size)) {
            if (map[y][x] == 0) {
                white++;
            }

            if (map[y][x] == 1) {
                blue++;
            }

            return;
        }

        int nextSize = size / 2;
        cutPaper(y, x, nextSize);
        cutPaper(y, x + nextSize, nextSize);
        cutPaper(y + nextSize, x, nextSize);
        cutPaper(y + nextSize, x + nextSize, nextSize);
    }

    private boolean checkPaper(int y, int x, int size) {
        int base = map[y][x];
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (base != map[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}

//public class Main {
//    public static void main(String[] args) throws IOException {
//        new B2630().solution();
//    }
//}
