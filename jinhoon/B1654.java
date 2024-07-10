package sol.jinhoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제: (B1654)
 * 풀이: 이분 탐색
 * 메모리: 17472kb
 * 시간: 184ms
 */
public class B1654 {

    public void solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] lines = new int[K];

        long max = -1;
        for (int i = 0; i < K; i++) {
            lines[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, lines[i]);
        }

        long min = 0;
        long mid = 0;
        while (min <= max) {
            mid = (max + min) / 2;

            long count = 0;
            // 만들어지는 전선 개수를 구한다
            for (int i = 0; i < lines.length; i++) {
                count += (lines[i] / mid);
            }

            if (count < N) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(min - 1);
    }
}

//public class Main {
//    public static void main(String[] args) throws IOException {
//        new B1654().solution();
//    }
//}
