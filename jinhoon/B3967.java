package sol.jinhoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문제: 매직스타 (B3967)
 * 풀이: 구현, dfs
 * 메모리: 16300kb
 * 시간: 132ms
 */
public class B3967 {

    char[][] map = new char[5][9];
    boolean[] visit, origin;
    int[] input;

    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        visit = new boolean[13];
        origin = new boolean[13];
        input = new int[13];


        int idx = 0;
        for (int i = 0; i < 5; i++) {
            String temp = br.readLine();
            for (int j = 0; j < 9; j++) {
                map[i][j] = temp.charAt(j);

                if (map[i][j] == 'x') {
                    input[++idx] = 0;
                } else if (map[i][j] >= 'A' && map[i][j] <= 'L') {
                    input[++idx] = map[i][j] - 'A' + 1;
                    origin[idx] = true;
                    visit[map[i][j] - 'A' + 1] = true;
                }
            }
        }

        dfs(1);
    }

    private void dfs(int idx) {
        if (idx == 6) {
            if ((input[2] + input[3] + input[4] + input[5]) != 26) return;
        } else if (idx == 9) {
            if ((input[1] + input[3] + input[6] + input[8]) != 26) return;
        } else if (idx == 12) {
            if ((input[1] + input[4] + input[7] + input[11]) != 26) return;
            if ((input[8] + input[9] + input[10] + input[11]) != 26) return;
        } else if (idx == 13) {
            if ((input[2] + input[6] + input[9] + input[12]) != 26) return;
            if ((input[5] + input[7] + input[10] + input[12]) != 26) return;
            print();
            System.exit(0);
        }

        if (origin[idx]) {
            dfs(idx + 1);
        }

        for (int i = 1; i < 13; i++) {
            if (visit[i] || origin[idx]) continue;
            visit[i] = true;
            input[idx] = i;
            dfs(idx + 1);
            input[idx] = 0;
            visit[i] = false;
        }
    }

    private void print() {
        int c = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 9; j++) {
                if (map[i][j] == '.') {
                    result.append('.');
                } else if (map[i][j] == 'x') {
                    result.append((char) (input[++c] + 'A' - 1));
                } else {
                    result.append(map[i][j]);
                    c++;
                }
            }
            result.append("\n");
        }
        System.out.println(result);
    }
}

//public class Main {
//    public static void main(String[] args) throws IOException {
//        new B3967().solution();
//    }
//}
