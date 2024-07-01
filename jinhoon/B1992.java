package sol.jinhoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 문제: (B1992)
 * 풀이: 구현(분할정복)
 * 1. 압축이 가능한지 확인하고 압축이 불가능하다면, 4분면으로 나누어서 압축한다.
 * 2. 4분면으로 나누었으면 다시 압축이 가능한지 확인하고 압축이 불가능하면 4분면으로 나눈다. 이를 반복한다.
 * 메모리: 14184kb
 * 시간: 136ms
 */
public class B1992 {

    StringBuilder result = new StringBuilder();
    int[][] arr = {};

    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            String numbers = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = numbers.charAt(j) - '0';
            }
        }

        makeQuad(0, 0, N);
        System.out.println(result);
    }

    private void makeQuad(int y, int x, int size) {

        if (checkBinary(y, x, size)) {
            result.append(arr[y][x]);
            return;
        }

        int nextSize = size / 2;

        result.append("(");

        makeQuad(y, x, nextSize);
        makeQuad(y, x + nextSize, nextSize);
        makeQuad(y + nextSize, x, nextSize);
        makeQuad(y + nextSize, x + nextSize, nextSize);

        result.append(")");
    }

    private boolean checkBinary(int y, int x, int size) {
        int first = arr[y][x];
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (arr[i][j] != first) {
                    return false;
                }
            }
        }
        return true;
    }
}

//public class Main {
//    public static void main(String[] args) throws IOException {
//        new B1992().solution();
//    }
//}
