package sol.jinhoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제: (S1210)
 * 풀이: 구현
 * 메모리: 217kb
 * 시간: 30,828ms
 */
public class S1210 {

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        StringTokenizer st;

        for (int test = 1; test <= 10; test++) {
            br.readLine();
            int[][] square = new int[100][102];

            for (int i = 0; i < 100; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= 100; j++) {
                    square[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int x = -1;
            for (int j = 1; j <= 100; j++) {
                if (square[99][j] == 2) {
                    x = j;
                }
            }

            int level = 98;
            while (level != 0) {
                // 왼쪽, 오른쪽 체크
                if (square[level][x - 1] == 1) {
                    x = x - 1;
                    while (square[level][x - 1] == 1) {
                        x = x - 1;
                    }
                } else if (square[level][x + 1] == 1) {
                    x = x + 1;
                    while (square[level][x + 1] == 1) {
                        x = x + 1;
                    }
                }

                level--;
            }

            result.append("#").append(test).append(" ").append(x - 1).append("\n");
        }


        System.out.println(result);
    }
}

