package sol.jinhoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제 : 2805 농작물 수확하기
 * 풀이 : 필요한 값만 더해서 구함
 * 메모리: 25,656 kbkb
 * 시간: 117ms
 */
public class S2805 {

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {

            int sum = 0;
            int N = Integer.parseInt(br.readLine());
            int base = N / 2;
            int margin = base;
            for (int i = 0; i < N; i++) {
                String numbers = br.readLine();

                // 여백을 두고 필요한 값만 더하게
                for (int j = margin; j < N - margin; j++) {
                    sum += Character.getNumericValue(numbers.charAt(j));
                }

                // 세로줄 기준 절반을 안지났으면 여백을 줄이고 반대면 여백을 늘림
                if (i < base) {
                    margin--;
                } else {
                    margin++;
                }
            }

            result.append("#").append(t).append(" ").append(sum).append("\n");
        }

        System.out.println(result);
    }
}

