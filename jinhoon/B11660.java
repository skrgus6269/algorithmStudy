package sol.jinhoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 구간 합 더하기 5
 * 1차 시도 Brute Fore : 시간초과
 * 2차 시도 누적합 알로리즘
 * 주의점 : 2차원 누접합 알고리즘 사용할때 중복되는 값 더해주기
 * 삽질 : x 가 행, y 가 열로 일반적으로 반대여서 삽질함
 */
public class B11660 {

    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] square = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int cur = Integer.parseInt(st.nextToken());
                square[i][j] = square[i - 1][j] + square[i][j - 1] + cur - square[i - 1][j - 1];
            }
        }

        StringBuilder result = new StringBuilder();

        for (int test = 0; test < m; test++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int sum = square[x2][y2] - square[x1 - 1][y2] - square[x2][y1 - 1] + square[x1 - 1][y1 - 1];

            result.append(sum).append(System.getProperty("line.separator"));
        }

        System.out.println(result);
    }
}

//public class Main {
//    public static void main(String[] args) throws IOException {
//        new B11660().solution();
//    }
//}
