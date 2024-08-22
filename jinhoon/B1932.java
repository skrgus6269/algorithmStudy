package sol.jinhoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제: 정수삼각형 (B1932)
 * 풀이: dp
 * 메모리: 25540kb
 * 시간: 240ms
 */
public class B1932 {

    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N + 2];

        map[0][1] = Integer.parseInt(br.readLine());
        int xNum = 3;
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < xNum; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = Math.max(map[i - 1][j - 1], map[i - 1][j]) + num;
            }
            xNum++;
        }

        int result = -1;
        for (int i = 1; i <= N; i++) {
            result = Math.max(result, map[N - 1][i]);
        }

        System.out.println(result);
    }
}

//public class Main {
//    public static void main(String[] args) throws IOException {
//        new B1932().solution();
//    }
//}
